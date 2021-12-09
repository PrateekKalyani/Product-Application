package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.room.ProductDao
import com.example.retrofitapplication.room.ProductEntity
import javax.inject.Inject

interface ProductCacheDataSource {

    fun getProducts() : LiveData<List<ProductEntity>>

    fun saveProducts(productList : List<ProductEntity>)
}

class ProductCacheDataSourceImpl
@Inject
constructor(
    private val productDao: ProductDao
    ): ProductCacheDataSource {

    override fun getProducts(): LiveData<List<ProductEntity>> {
        return productDao.getProducts()
    }

    override fun saveProducts(productList: List<ProductEntity>) {
        productDao.insertProducts(productList)
    }

}