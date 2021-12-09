package com.example.retrofitapplication.di

import android.content.Context
import com.example.retrofitapplication.data.*
import com.example.retrofitapplication.domain.ProductUseCase
import com.example.retrofitapplication.mapper.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    fun getContext(@ApplicationContext context: Context) : Context {
        return context
    }

    @Provides
    fun getCacheMapper() : CacheMapper {
        return CacheMapper()
    }

    @Provides
    fun getProductRemoteDataSource(productApiService : ProductApiService) : ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(productApiService = productApiService)
    }

    @Provides
    fun getProductRepository(
        productRemoteDataSource: ProductRemoteDataSource,
        cacheMapper: CacheMapper
    ) : ProductRepository {

        return ProductRepositoryImpl(
            productRemoteDataSource = productRemoteDataSource,
            cacheMapper = cacheMapper
        )
    }

    @Provides
    fun getProductUserCase(productRepository: ProductRepository) : ProductUseCase {
        return ProductUseCase(productRepository =  productRepository)
    }
}