package com.cook.chefcrate.recipeapp.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cook.chefcrate.R
import com.cook.chefcrate.databinding.ItemRvMainCategoryBinding
import com.cook.chefcrate.recipeapp.model.entities.Recipes

class MainCategoryAdapter(context: Context) : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>(){

    var layoutInflater : LayoutInflater
    var arrMainCategory = ArrayList<Recipes>()

    private var _binding : ItemRvMainCategoryBinding? = null
    private val binding get() = _binding!!

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view)

    init{
        layoutInflater = LayoutInflater.from(context)
    }
    fun setData(arrData : List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        _binding = ItemRvMainCategoryBinding.inflate(layoutInflater)
        binding.tvDishName.text = arrMainCategory[position].dishName
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
}