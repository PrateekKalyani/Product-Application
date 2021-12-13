package com.example.retrofitapplication.ui

import androidx.lifecycle.*
import com.example.retrofitapplication.domain.ProductUseCase
import com.example.retrofitapplication.models.ProductModel
import com.example.retrofitapplication.models.ProductResponse
import com.example.retrofitapplication.models.UiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(
    private val productUseCase: ProductUseCase,
    private val savedStateHandle: SavedStateHandle,
    ) : ViewModel() {

    private val _productListUiEvents = MutableLiveData<UiEvents<List<ProductModel>>>()
    val productListUiEvents : LiveData<UiEvents<List<ProductModel>>>
    get() = _productListUiEvents

    fun getProducts() {
        viewModelScope.launch {

            when(val result = productUseCase.getProducts()) {

                is ProductResponse.Success -> {
                    _productListUiEvents.postValue(UiEvents.Success(result.productList))
                }
                is ProductResponse.Error -> {
                    _productListUiEvents.postValue(UiEvents.Error(result.error))
                }

                is ProductResponse.Loading -> {

                }
            }
        }
    }
}