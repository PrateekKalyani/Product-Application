package com.example.retrofitapplication.data

import com.example.retrofitapplication.models.ProductModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductApiService {

    @GET("products/")
    suspend fun getData() : Response<List<ProductModel>>
}