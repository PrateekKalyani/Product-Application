package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.models.ProductModel
import javax.inject.Inject

interface ProductRepository {

    fun getProduct() : LiveData<List<ProductModel>>
}

class ProductRepositoryImpl
    @Inject
    constructor (
        private val productRemoteDataSource: ProductRemoteDataSource,
        private val cacheMapper : CacheMapper
        ) : ProductRepository {

    override fun getProduct(): LiveData<List<ProductModel>> {

        return productRemoteDataSource.getProduct()
    }
}
