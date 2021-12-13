package com.example.retrofitapplication.data

import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.models.ProductResponse
import javax.inject.Inject

interface ProductRepository {

    suspend fun getProducts(isConnected: Boolean) : ProductResponse
}

class ProductRepositoryImpl
@Inject
constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productCacheDataSource: ProductCacheDataSource,
    private val cacheMapper : CacheMapper
    ) : ProductRepository {

    override suspend fun getProducts(isConnected : Boolean): ProductResponse {

        return if(isConnected) {
            val productResponse = productRemoteDataSource.getProducts()

            if(productResponse is ProductResponse.Success) {
                productCacheDataSource.saveProducts(
                    productList = cacheMapper.mapToEntityList(
                        domainModelList = productResponse.productList
                    )
                )
            }
            productResponse
        } else {
            val productList = productCacheDataSource.getProducts()

            if(productList.isEmpty()) {
                ProductResponse.Error("List Empty in Cache")
            } else {
                ProductResponse.Success(cacheMapper.mapFromEntityList(productList))
            }
        }
    }
}
