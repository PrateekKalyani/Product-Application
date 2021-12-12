package com.example.retrofitapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityProductBinding
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

        viewModel.productList.observe(this, Observer { ProductList ->
            if (ProductList != null) {
                (binding.productRecyclerView.adapter as ProductAdapter).submitList(productList = ProductList)
            }
        })

        viewModel.getProducts()
    }
}