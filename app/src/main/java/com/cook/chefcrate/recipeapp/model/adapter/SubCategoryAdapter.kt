package com.cook.chefcrate.recipeapp.model.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cook.chefcrate.databinding.ItemRvSubCategoryBinding
import com.cook.chefcrate.recipeapp.model.entities.Recipes

class SubCategoryAdapter() : RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>(){

    var arrSubCategory = ArrayList<Recipes>()

    class RecipeViewHolder(val binding: ItemRvSubCategoryBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(arrData : List<Recipes>){
        arrSubCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRvSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        with(holder){
            with(arrSubCategory[position]) {
                binding.tvDishName.text = arrSubCategory[position].dishName
            }
        }
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }
}