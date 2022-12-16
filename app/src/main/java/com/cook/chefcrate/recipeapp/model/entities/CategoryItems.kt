package com.cook.chefcrate.recipeapp.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CategoryItems")
data class CategoryItems(
    @PrimaryKey(autoGenerate = true)
    var id:Int,


    @Expose
    @ColumnInfo(name = "idcategory")
    @SerializedName("idCategory")
    val idcategory: String,


    @Expose
    @ColumnInfo(name = "strcategory")
    @SerializedName("strCategory")
    val strcategory: String,


    @Expose
    @ColumnInfo(name = "strcategorythumb")
    @SerializedName("strCategoryThumb")
    val strcategorythumb: String,


    @Expose
    @ColumnInfo(name = "strcategorydescription")
    @SerializedName("strCategoryDescription")
    val strcategorydescription: String
)