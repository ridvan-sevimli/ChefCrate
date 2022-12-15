package com.cook.chefcrate.recipeapp.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cook.chefcrate.R
import com.cook.chefcrate.databinding.ItemRvSubCategoryBinding
import com.cook.chefcrate.recipeapp.model.entities.Recipes

class SubCategoryAdapter(context: Context) : RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>(){

    var layoutInflater : LayoutInflater
    var arrSubCategory = ArrayList<Recipes>()

    private var _binding : ItemRvSubCategoryBinding? = null
    private val binding get() = _binding!!

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view)

    init{
        layoutInflater = LayoutInflater.from(context)
    }
    fun setData(arrData : List<Recipes>){
        arrSubCategory = arrData as ArrayList<Recipes>
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        _binding = ItemRvSubCategoryBinding.inflate(layoutInflater)
        binding.tvDishName.text = arrSubCategory[position].dishName
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }
}