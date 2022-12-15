package com.cook.chefcrate.recipeapp.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.cook.chefcrate.recipeapp.model.entities.Recipes


//Dao: Database Access Object
@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes ORDER BY id DESC")
    fun allRecipes(): List<Recipes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipes: Recipes)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg recipes: Recipes)

}