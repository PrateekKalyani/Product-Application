package com.example.retrofitapplication.domain

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.ProductModel
import com.example.retrofitapplication.models.Product
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    fun getProduct(): LiveData<List<Product>> {
        return productRepository.getProduct()
    }
}