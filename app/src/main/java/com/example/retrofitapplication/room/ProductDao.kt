package com.example.retrofitapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(productList : List<ProductEntity>)

    @Query("SELECT * FROM products")
    suspend fun getProducts() : List<ProductEntity>
}