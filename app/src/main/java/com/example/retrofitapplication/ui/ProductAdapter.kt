package com.example.retrofitapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapplication.ProductModel
import com.example.retrofitapplication.R
import com.example.retrofitapplication.databinding.SingleProductItemBinding

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    private val productList by lazy { mutableListOf<ProductModel>() }

    class ProductViewHolder(private val binding : SingleProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context by lazy { binding.root.context }

        fun bind(
            product : ProductModel
        ) {
            binding.run {
                productTitle.text = product.title
                productDescription.text = product.description
                priceText.text = "Price : ${product.price}"
                categoryText.text  = "Category : ${product.category}"
                rateText.text = "Rate : ${product.rating.rate}"
                countText.text = "Count : ${product.rating.count}"

                Glide.with(context)
                    .load(product.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(productImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(SingleProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.bind(product = productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun submitList(productList : List<ProductModel>) {
        this.productList.addAll(productList)
        notifyDataSetChanged()
    }
}