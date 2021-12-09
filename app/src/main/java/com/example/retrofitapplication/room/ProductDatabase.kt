package com.example.retrofitapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase(){

    companion object {
        const val databaseName : String = "ProductDatabase"
    }

    abstract fun productDao() : ProductDao
}