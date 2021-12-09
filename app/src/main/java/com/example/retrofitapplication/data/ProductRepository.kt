package com.example.retrofitapplication.domain

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.ProductModel
import com.example.retrofitapplication.data.ProductRemoteDataSource
import javax.inject.Inject

interface ProductRepository{

    fun getProduct() : LiveData<List<ProductModel>>
}

class ProductRepositoryImpl
    @Inject
    constructor (
        private val productRemoteDataSource: ProductRemoteDataSource
        ) : ProductRepository {

    override fun getProduct(): LiveData<List<ProductModel>> {
        return productRemoteDataSource.getProduct()
    }
}