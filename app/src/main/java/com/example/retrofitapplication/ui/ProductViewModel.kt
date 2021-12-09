package com.example.retrofitapplication.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.retrofitapplication.ProductModel
import com.example.retrofitapplication.domain.ProductUseCase
import com.example.retrofitapplication.interfaces.CacheMapper
import com.example.retrofitapplication.interfaces.NetworkMapper
import com.example.retrofitapplication.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(
    private val productUseCase: ProductUseCase,
    private val savedStateHandle: SavedStateHandle,
    ) : ViewModel(), LifecycleObserver {

    fun getProducts(): LiveData<List<Product>>{
        return productUseCase.getProduct()
    }
}