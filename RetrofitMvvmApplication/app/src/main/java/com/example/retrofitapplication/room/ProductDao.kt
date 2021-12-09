package com.example.retrofitapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product : ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(productList : List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun getProducts() : LiveData<List<ProductEntity>>
}