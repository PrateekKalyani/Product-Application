package com.example.retrofitapplication.data

import com.example.retrofitapplication.models.ProductResponse
import javax.inject.Inject

interface ProductRemoteDataSource {

    suspend fun getProducts() : ProductResponse
}

class ProductRemoteDataSourceImpl
@Inject
constructor(
    private val productApiService: ProductApiService
    ) : ProductRemoteDataSource {

    override suspend fun getProducts(): ProductResponse {

        return try {
            val response = productApiService.getData()

            if (response.isSuccessful && response.body() != null) {
                ProductResponse.Success(response.body()!!)
            } else {
                ProductResponse.Error("Server Error")
            }

        } catch (e : Exception) {
            ProductResponse.Error(e.localizedMessage)
        }
    }
}
