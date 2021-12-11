package com.example.retrofitapplication.di

import android.content.Context
import com.example.retrofitapplication.data.*
import com.example.retrofitapplication.domain.ProductUseCase
import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    fun getUtil(@ApplicationContext context: Context) : Util {
        return Util(
            context = context
        )
    }

    @Provides
    fun getCacheMapper() : CacheMapper {
        return CacheMapper()
    }

    @Provides
    fun getProductRemoteDataSource(productApiService : ProductApiService) : ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(
            productApiService = productApiService
        )
    }

    @Provides
    fun getProductRepository(
        productRemoteDataSource: ProductRemoteDataSource,
        productCacheDataSource: ProductCacheDataSource,
        cacheMapper: CacheMapper
    ) : ProductRepository {

        return ProductRepositoryImpl(
            productRemoteDataSource = productRemoteDataSource,
            productCacheDataSource = productCacheDataSource,
            cacheMapper = cacheMapper
        )
    }

    @Provides
    fun getProductUserCase(productRepository: ProductRepository, util: Util) : ProductUseCase {
        return ProductUseCase(
            productRepository =  productRepository,
            util =  util
        )
    }
}