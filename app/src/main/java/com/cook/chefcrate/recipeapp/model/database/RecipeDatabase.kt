package com.cook.chefcrate.recipeapp.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cook.chefcrate.recipeapp.model.dao.RecipeDao
import com.cook.chefcrate.recipeapp.model.entities.Recipes


@Database(entities = [Recipes::class],version = 2,exportSchema = false)
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