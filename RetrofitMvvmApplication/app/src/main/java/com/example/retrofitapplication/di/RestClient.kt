package com.example.retrofitapplication.di

import com.example.retrofitapplication.data.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RestClient {

    private const val BASE_URL = "https://fakestoreapi.com/"
    private var apiService : ProductApiService? = null

    @Provides
    fun getApiService(): ProductApiService {

        if(apiService == null) {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            apiService = retrofit.create(ProductApiService::class.java)
        }

        return apiService!!
    }
}