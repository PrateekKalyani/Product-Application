package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.room.ProductDao
import com.example.retrofitapplication.room.ProductEntity
import javax.inject.Inject

interface ProductCacheDataSource {

    fun getProduct() : LiveData<List<ProductEntity>>

    fun saveProducts(productList : List<ProductEntity>)
}

class ProductCacheDataSourceImpl
@Inject
constructor(
    private val productDao: ProductDao
    ): ProductCacheDataSource {

    override fun getProduct(): LiveData<List<ProductEntity>> {
        val productList = productDao.getProducts()
        return productList
    }

    override fun saveProducts(productList: List<ProductEntity>) {
        productDao.insertProducts(productList)
    }

}