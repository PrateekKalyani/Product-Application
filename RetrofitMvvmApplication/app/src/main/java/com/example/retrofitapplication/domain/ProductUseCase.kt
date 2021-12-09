package com.example.retrofitapplication.domain

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.ProductModel
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    fun getProduct(): LiveData<List<ProductModel>> {
        return productRepository.getProduct()
    }
}