package com.example.retrofitapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel : ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()
        setProductList()
    }

    private fun setRecyclerView() {

        binding.productRecyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter()
        }
    }

    private fun setProductList() {

        viewModel.getProducts().observe(this, Observer {list ->
            if (list != null) {
                (binding.productRecyclerView.adapter as ProductAdapter).submitList(list)
            }
        })
    }
}