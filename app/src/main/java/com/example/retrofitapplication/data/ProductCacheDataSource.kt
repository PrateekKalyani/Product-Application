package com.example.retrofitapplication.data

import com.example.retrofitapplication.room.ProductDao
import com.example.retrofitapplication.room.ProductEntity
import javax.inject.Inject

interface ProductCacheDataSource {

    suspend fun getProducts() : List<ProductEntity>

    suspend fun saveProducts(productList : List<ProductEntity>)
}

class ProductCacheDataSourceImpl
@Inject
constructor(
    private val productDao: ProductDao
    ): ProductCacheDataSource {

    override suspend fun getProducts(): List<ProductEntity> {
        return productDao.getProducts()
    }

    override suspend fun saveProducts(productList: List<ProductEntity>) {

        if(productList.isEmpty()) {
            return
        }
        productDao.insertProducts(productList = productList)
    }

}