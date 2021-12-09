package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitapplication.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface ProductRemoteDataSource {

    fun getProduct() : LiveData<List<ProductModel>>

}

class ProductRemoteDataSourceImpl
    @Inject
    constructor(
        private val productApiService: ProductApiService
        ) : ProductRemoteDataSource {

    private var answer : MutableLiveData<List<ProductModel>> = MutableLiveData()

    override fun getProduct(): LiveData<List<ProductModel>> {

        productApiService.getData().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                answer.postValue(response.body())
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {

            }
        })

        return answer
    }

}
