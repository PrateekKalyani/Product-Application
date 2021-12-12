package com.example.retrofitapplication.data

import com.example.retrofitapplication.models.ProductModel
import javax.inject.Inject

interface ProductRemoteDataSource {

    suspend fun getProducts() : List<ProductModel>
}

class ProductRemoteDataSourceImpl
@Inject
constructor(
    private val productApiService: ProductApiService
    ) : ProductRemoteDataSource {

    override suspend fun getProducts(): List<ProductModel> {

        val productList = mutableListOf<ProductModel>()
        try {
            val data = productApiService.getData()
            if (data.isSuccessful) {
                productList.addAll(elements = data.body()!!)
            }
        }
        catch (e : Exception) {

        }
        return productList
    }
}
