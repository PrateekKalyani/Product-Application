package com.example.retrofitapplication.domain

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.data.ProductRepository
import com.example.retrofitapplication.models.ProductModel
import javax.inject.Inject

class ProductUseCase @Inject
constructor(
    private val productRepository: ProductRepository
) {

    suspend fun getProduct(): List<ProductModel> {
        return productRepository.getProduct()
    }
}