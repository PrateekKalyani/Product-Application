package com.example.retrofitapplication.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.retrofitapplication.ProductModel
import com.example.retrofitapplication.data.ProductRemoteDataSource
import com.example.retrofitapplication.interfaces.CacheMapper
import com.example.retrofitapplication.interfaces.NetworkMapper
import com.example.retrofitapplication.models.Product
import javax.inject.Inject

interface ProductRepository{

    fun getProduct() : LiveData<List<Product>>
}

class ProductRepositoryImpl
    @Inject
    constructor (
        private val productRemoteDataSource: ProductRemoteDataSource,
        val networkMapper: NetworkMapper,
        val chacheMapper : CacheMapper
        ) : ProductRepository {

    override fun getProduct(): LiveData<List<Product>> {

        val productList = Transformations.map(productRemoteDataSource.getProduct()) {
            networkMapper.mapFromEntityList(it)
        }

        return productList
    }
}