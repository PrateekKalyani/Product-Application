package com.example.retrofitapplication.di

import com.example.retrofitapplication.data.ProductApiService
import com.example.retrofitapplication.data.ProductRemoteDataSource
import com.example.retrofitapplication.data.ProductRemoteDataSourceImpl
import com.example.retrofitapplication.domain.ProductRepository
import com.example.retrofitapplication.domain.ProductRepositoryImpl
import com.example.retrofitapplication.domain.ProductUseCase
import com.example.retrofitapplication.interfaces.CacheMapper
import com.example.retrofitapplication.interfaces.NetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    fun getProductRemoteDataSource(productApiService : ProductApiService) : ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(productApiService = productApiService)
    }

    @Provides
    fun getNetworkMapper() : NetworkMapper {
        return NetworkMapper()
    }

    @Provides
    fun getCacheMapper() : CacheMapper {
        return CacheMapper()
    }

    @Provides
    fun getProductRepository(productRemoteDataSource: ProductRemoteDataSource,
    networkMapper: NetworkMapper,
    cacheMapper: CacheMapper) : ProductRepository {
        return ProductRepositoryImpl(productRemoteDataSource = productRemoteDataSource, networkMapper = networkMapper, chacheMapper = cacheMapper)
    }

    @Provides
    fun getProductUserCase(productRepository: ProductRepository) : ProductUseCase {
        return ProductUseCase(productRepository =  productRepository)
    }
}