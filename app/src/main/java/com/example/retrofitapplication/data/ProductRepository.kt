package com.example.retrofitapplication.data

import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.models.ProductModel
import java.lang.Exception
import javax.inject.Inject

interface ProductRepository {

    suspend fun getProduct(isConnected: Boolean) : List<ProductModel>
}

class ProductRepositoryImpl
    @Inject
    constructor(
        private val productRemoteDataSource: ProductRemoteDataSource,
        private val productCacheDataSource: ProductCacheDataSource,
        private val cacheMapper : CacheMapper
        ) : ProductRepository {

    override suspend fun getProduct(isConnected : Boolean): List<ProductModel> {

        val productList = mutableListOf<ProductModel>()

        if(isConnected) {

            try {

                productList.addAll(productRemoteDataSource.getProduct())
                productCacheDataSource.saveProducts(cacheMapper.mapToEntityList(productList))

            } catch (e : Exception) {

            }

        } else {

            productList.addAll(cacheMapper.mapFromEntityList(productCacheDataSource.getProducts()))
        }

        return productList
    }
}
