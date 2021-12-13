package com.example.retrofitapplication.models

sealed class UiEvents <out T>{
    data class Success<T>(val result: T) : UiEvents<T>()
    data class Error(val error: String) : UiEvents<Nothing>()
    object Loading : UiEvents<Nothing>()
}
