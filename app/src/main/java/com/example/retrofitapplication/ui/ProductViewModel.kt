package com.example.retrofitapplication.ui

import androidx.lifecycle.*
import com.example.retrofitapplication.domain.ProductUseCase
import com.example.retrofitapplication.models.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(
    private val productUseCase: ProductUseCase,
    private val savedStateHandle: SavedStateHandle,
    ) : ViewModel(), LifecycleObserver {

    private val _productList = MutableLiveData<List<ProductModel>>()
    val productList : LiveData<List<ProductModel>>
    get() = _productList

    fun getProducts() {
        viewModelScope.launch {
            _productList.postValue(productUseCase.getProduct())
        }
    }
}