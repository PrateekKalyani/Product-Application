package com.example.retrofitapplication.di

import com.example.retrofitapplication.data.ProductApiService
import com.example.retrofitapplication.data.ProductRemoteDataSource
import com.example.retrofitapplication.data.ProductRemoteDataSourceImpl
import com.example.retrofitapplication.domain.ProductRepository
import com.example.retrofitapplication.domain.ProductRepositoryImpl
import com.example.retrofitapplication.domain.ProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    fun getProductRemoteDataSource(productApiService : ProductApiService) : ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(productApiService = productApiService)
    }

    @Provides
    fun getProductRepository(productRemoteDataSource: ProductRemoteDataSource) : ProductRepository {
        return ProductRepositoryImpl(productRemoteDataSource = productRemoteDataSource)
    }

    @Provides
    fun getProductUserCase(productRepository: ProductRepository) : ProductUseCase {

        return ProductUseCase(productRepository =  productRepository)
    }
}