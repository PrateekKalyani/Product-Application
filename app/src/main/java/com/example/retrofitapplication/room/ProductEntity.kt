package com.example.retrofitapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.retrofitapplication.RatingModel

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "price")
    val price : Float,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "category")
    val category : String,
    @ColumnInfo(name = "image")
    val image : String,
    @ColumnInfo(name = "rating")
    val rating : RatingModel
)
