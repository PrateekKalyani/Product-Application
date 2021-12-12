package com.example.retrofitapplication.domain

import com.example.retrofitapplication.data.ProductRepository
import com.example.retrofitapplication.models.ProductModel
import com.example.retrofitapplication.util.Util
import javax.inject.Inject

class ProductUseCase
@Inject
constructor(
    private val productRepository: ProductRepository,
    private val util: Util
    ) {

    suspend fun getProduct(): List<ProductModel> {
        return productRepository.getProducts(isConnected = util.checkForInternet())
    }
}