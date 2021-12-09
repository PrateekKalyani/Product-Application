package com.example.retrofitapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase(){

    abstract fun productDao() : ProductDao

    companion object {
        const val databaseName : String = "ProductDatabase"
    }
}