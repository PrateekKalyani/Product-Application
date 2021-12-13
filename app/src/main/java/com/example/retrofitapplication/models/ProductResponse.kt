package com.example.retrofitapplication.models

sealed class ProductResponse {

    data class Success(val productList: List<ProductModel>) : ProductResponse()
    data class Error(val error: String) : ProductResponse()
    object Loading : ProductResponse()
}

