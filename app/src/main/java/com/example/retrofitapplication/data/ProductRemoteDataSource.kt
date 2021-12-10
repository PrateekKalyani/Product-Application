package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitapplication.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface ProductRemoteDataSource {

    suspend fun getProduct() : List<ProductModel>
}

class ProductRemoteDataSourceImpl
    @Inject
    constructor(
        private val productApiService: ProductApiService
        ) : ProductRemoteDataSource {


    override suspend fun getProduct(): List<ProductModel> {
        return productApiService.getData().body()!!
    }
}
