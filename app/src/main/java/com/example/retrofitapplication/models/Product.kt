package com.example.retrofitapplication.models

import com.example.retrofitapplication.RatingModel

data class Product(
    val id : Int,
    val title : String,
    val price : Float,
    val description : String,
    val category : String,
    val image : String,
    val rating : RatingModel
)
