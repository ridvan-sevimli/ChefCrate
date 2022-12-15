package com.cook.chefcrate.recipeapp.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cook.chefcrate.databinding.ItemRvMainCategoryBinding
import com.cook.chefcrate.recipeapp.model.entities.Recipes

class MainCategoryAdapter() : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>(){

    var arrMainCategory = ArrayList<Recipes>()

    class RecipeViewHolder(val binding: ItemRvMainCategoryBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(arrData : List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        with(holder){
            with(arrMainCategory[position]) {
                binding.tvDishName.text = arrMainCategory[position].dishName
            }
        }
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
}