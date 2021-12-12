package com.example.retrofitapplication.data

import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.models.ProductModel
import javax.inject.Inject

interface ProductRepository {

    suspend fun getProducts(isConnected: Boolean) : List<ProductModel>
}

class ProductRepositoryImpl
@Inject
constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productCacheDataSource: ProductCacheDataSource,
    private val cacheMapper : CacheMapper
    ) : ProductRepository {

    override suspend fun getProducts(isConnected : Boolean): List<ProductModel> {

        val productList = mutableListOf<ProductModel>()
        if(isConnected) {
            try {
                productList.addAll(
                    elements = productRemoteDataSource.getProducts()
                )
                productCacheDataSource.saveProducts(
                    productList = cacheMapper.mapToEntityList(productList)
                )
            } catch (e : Exception) {

            }
        } else {
            productList.addAll(
                elements = cacheMapper.mapFromEntityList(
                    entityList = productCacheDataSource.getProducts()
                )
            )
        }
        return productList
    }
}
