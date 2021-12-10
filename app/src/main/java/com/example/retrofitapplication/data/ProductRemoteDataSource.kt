package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitapplication.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface ProductRemoteDataSource {

    suspend fun getProduct() : LiveData<List<ProductModel>>
}

class ProductRemoteDataSourceImpl
    @Inject
    constructor(
        private val productApiService: ProductApiService
        ) : ProductRemoteDataSource {

    private var productList = MutableLiveData<List<ProductModel>>()

    override suspend fun getProduct(): MutableLiveData<List<ProductModel>> {

        try {
            val response = productApiService.getData()

            if(response.isSuccessful) {
                println("data : ${response.body()!!}")
                productList.postValue(response.body()!!)
            }

        } catch (e : Exception) {
            println("exception : $e")
        }

        return productList
    }
}
