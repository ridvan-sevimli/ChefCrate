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
import com.cook.chefcrate.databinding.FragmentHomeBinding
import com.cook.chefcrate.recipeapp.model.adapter.MainCategoryAdapter
import com.cook.chefcrate.recipeapp.model.adapter.SubCategoryAdapter
import com.cook.chefcrate.recipeapp.model.dataView.RecipeDataViewModel
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

        var mainCategoryAdapter = MainCategoryAdapter()
        var subCategoryAdapter = SubCategoryAdapter()

        arrMainCategory.add( Recipes(1, dishName = "Beef"))
        arrMainCategory.add( Recipes(2, dishName = "Chicken"))
        arrMainCategory.add( Recipes(3, dishName = "Dessert"))
        arrMainCategory.add( Recipes(4,dishName="Lamb"))
        arrMainCategory.add( Recipes(5, dishName = "Beef"))
        arrMainCategory.add( Recipes(6, dishName = "Chicken"))
        arrMainCategory.add( Recipes(7, dishName = "Dessert"))
        arrMainCategory.add( Recipes(8,dishName="Lamb"))


        arrSubCategory.add( Recipes(1, dishName = "Beef and mustard pie"))
        arrSubCategory.add( Recipes(2, dishName = "Chicken and mushroom hotpot"))
        arrSubCategory.add( Recipes(3, dishName = "Banana pancakes"))
        arrSubCategory.add( Recipes(4,dishName="kapsalon"))
        arrSubCategory.add( Recipes(5, dishName = "Beef and mustard pie"))
        arrSubCategory.add( Recipes(6, dishName = "Chicken and mushroom hotpot"))
        arrSubCategory.add( Recipes(7, dishName = "Dessert"))
        arrSubCategory.add( Recipes(8,dishName="Lamb"))

        mainCategoryAdapter.setData(arrMainCategory)
        subCategoryAdapter.setData(arrSubCategory)

        binding.rvMainCategory.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvMainCategory.adapter = mainCategoryAdapter

        binding.rvSubCategory.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvSubCategory.adapter = subCategoryAdapter

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