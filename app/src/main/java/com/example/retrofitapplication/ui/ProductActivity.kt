package com.example.retrofitapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityProductBinding
import com.example.retrofitapplication.models.UiEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    private val binding by lazy { ActivityProductBinding.inflate(layoutInflater) }
    private val viewModel : ProductViewModel by lazy {
        ViewModelProvider(this)[ProductViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()
        setProductList()
    }

    private fun setRecyclerView() {

        binding.productRecyclerView.run {
            layoutManager = LinearLayoutManager(this@ProductActivity)
            adapter = ProductAdapter()
        }

        binding.productRefreshLayout.setOnRefreshListener {
            viewModel.getProducts()
            binding.productRefreshLayout.isRefreshing = false
        }
    }

    private fun setProductList() {

        viewModel.productListUiEvents.observe(this, Observer {
            when(it) {

                is UiEvents.Success -> {
                    (binding.productRecyclerView.adapter as ProductAdapter).submitList(productList = it.result)
                }

                is UiEvents.Error -> {
                    Toast.makeText(
                        this@ProductActivity,
                        it.error,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is UiEvents.Loading -> {

                }
            }
        })

        viewModel.getProducts()
    }
}