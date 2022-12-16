package com.cook.chefcrate


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Klaxon
import com.cook.chefcrate.databinding.FragmentHomeBinding
import com.cook.chefcrate.recipeapp.model.adapter.MainCategoryAdapter
import com.cook.chefcrate.recipeapp.model.adapter.SubCategoryAdapter
import com.cook.chefcrate.recipeapp.model.dataView.RecipeDataViewModel
import com.cook.chefcrate.recipeapp.model.entities.Categories
import com.cook.chefcrate.recipeapp.model.entities.Recipes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         *  my implementation
         */

        val model: RecipeDataViewModel by activityViewModels()
        model.initDB(requireContext())

        lifecycleScope.launchWhenStarted{
            withContext(Dispatchers.Default){
                model.readRecipes()
            }
        }

        val inputStream = requireContext().resources.openRawResource(R.raw.categories)
        //val categories = Klaxon().parse<Categories>(inputStream)

        var mainCategoryAdapter = MainCategoryAdapter()
        var subCategoryAdapter = SubCategoryAdapter()


        arrSubCategory.add( Recipes(1, dishName = "Beef and mustard pie","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(2, dishName = "Chicken and mushroom hotpot","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(3, dishName = "Banana pancakes","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(4,dishName="kapsalon","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(5, dishName = "Beef and mustard pie","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(6, dishName = "Chicken and mushroom hotpot","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(7, dishName = "Dessert","https://www.themealdb.com/images/category/chicken.png"))
        arrSubCategory.add( Recipes(8,dishName="Lamb","https://www.themealdb.com/images/category/chicken.png"))



        binding.rvMainCategory.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


        binding.rvSubCategory.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


        var text :String
        val url = "https://imdb-api.com/en/API/ComingSoon/k_dpwxdc3v"
        var categories :Categories? = null
        val requestQueue = Volley.newRequestQueue(requireContext())
        val request = StringRequest(Request.Method.GET, "https://www.themealdb.com/api/json/v1/1/categories.php", Response.Listener<String> { response ->
            categories = Klaxon().parse<Categories>(response)

            for(category in categories?.categories!!){
                arrMainCategory.add(Recipes(category.idCategory.toInt(), category.strCategory,category.strCategoryThumb))
            }
            mainCategoryAdapter.setData(arrMainCategory)
            subCategoryAdapter.setData(arrSubCategory)

            binding.rvSubCategory.adapter = subCategoryAdapter
            binding.rvMainCategory.adapter = mainCategoryAdapter
        },
            Response.ErrorListener {

            })

        requestQueue.add(request)

//        model.recipes.observe(viewLifecycleOwner,
//            // note that the observer sends the new value as parameter
//            Observer<MutableList<Recipes>>{newVal ->
////                adapter?.clear()
////                adapter?.addAll(newVal) // addAll will call notifyDatasetChanged
//
//            })

        /**
         *  my implementation
         */

        //binding.buttonSecond.setOnClickListener {
          //  findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}