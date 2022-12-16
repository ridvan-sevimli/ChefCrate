package com.cook.chefcrate.recipeapp.model.dataView

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.cook.chefcrate.recipeapp.model.database.RecipeDatabase
import com.cook.chefcrate.recipeapp.model.entities.Recipes

class RecipeDataViewModel : ViewModel() {

    var db : RecipeDatabase? = null
    var recipes = MutableLiveData<MutableList<Recipes>>()

    init{
        recipes.value = mutableListOf<Recipes>()
    }

    fun initDB(context: Context){
        db = Room.databaseBuilder(
            context,
            RecipeDatabase::class.java, "database-recipes"
        ).build()
    }

    suspend fun insertRecipe(){
        db?.recipeDao()?.insertAll(

            // temporary data
//            Recipes(1, dishName = "Beef"),
//            Recipes(2, dishName = "Chicken"),
//            Recipes(3, dishName = "Dessert"),
//            Recipes(4,dishName="Lamb")
        )
    }
    suspend fun readRecipes(){
        val data = db?.recipeDao()?.allRecipes()?.toMutableList()
        recipes.postValue(data!!)
    }
}