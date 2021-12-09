package com.example.retrofitapplication

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName(value = "id")
    val id : Int,
    @SerializedName(value = "title")
    val title : String,
    @SerializedName(value = "price")
    val price : Float,
    @SerializedName(value = "description")
    val description : String,
    @SerializedName(value = "category")
    val category : String,
    @SerializedName(value = "image")
    val image : String,
    @SerializedName(value = "rating")
    val rating : RatingModel
)

data class RatingModel(
    @SerializedName(value = "rate")
    val rate : Float,
    @SerializedName(value = "count")
    val count : Int
)