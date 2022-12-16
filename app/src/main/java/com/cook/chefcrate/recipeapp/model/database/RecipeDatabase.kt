package com.cook.chefcrate.recipeapp.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cook.chefcrate.recipeapp.model.dao.RecipeDao
import com.cook.chefcrate.recipeapp.model.entities.Category
import com.cook.chefcrate.recipeapp.model.entities.CategoryItems
import com.cook.chefcrate.recipeapp.model.entities.Recipes
import com.cook.chefcrate.recipeapp.model.entities.converter.CategoryListConverter

@Database(entities = [Recipes::class, Category::class,CategoryItems::class, CategoryListConverter::class],version = 1,exportSchema = false)
abstract class RecipeDatabase : RoomDatabase(){

    companion object{
        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if(recipesDatabase != null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao(): RecipeDao
}