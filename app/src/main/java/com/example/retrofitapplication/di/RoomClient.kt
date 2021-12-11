package com.example.retrofitapplication.di

import android.content.Context
import androidx.room.Room
import com.example.retrofitapplication.data.ProductCacheDataSource
import com.example.retrofitapplication.data.ProductCacheDataSourceImpl
import com.example.retrofitapplication.room.ProductDao
import com.example.retrofitapplication.room.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomClient {

    private var databaseBuilder : ProductDao? = null

    @Provides
    fun provideProductDao(@ApplicationContext context : Context) : ProductDao{

        if(databaseBuilder == null) {
            databaseBuilder = Room.databaseBuilder(
                context,
                ProductDatabase::class.java,
                ProductDatabase.databaseName
                ).build().productDao()
        }

        return databaseBuilder!!
    }

    @Provides
    fun getProductCacheDataSource(productDao: ProductDao) : ProductCacheDataSource {
        return ProductCacheDataSourceImpl(productDao = productDao)
    }
}