package com.example.retrofitapplication.data

import com.example.retrofitapplication.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductApiService {

    @GET("products/")
    fun getData() : Call<List<ProductModel>>
}