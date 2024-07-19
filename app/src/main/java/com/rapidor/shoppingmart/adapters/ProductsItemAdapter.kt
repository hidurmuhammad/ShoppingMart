
package com.rapidor.shoppingmart.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rapidor.shoppingmart.databinding.ProductListItemBinding
import com.rapidor.shoppingmart.model.ProductsItem
import com.rapidor.shoppingmart.view.fragment.HomeFragmentDirections

class ProductsItemAdapter : ListAdapter<ProductsItem, ProductsItemAdapter.MyViewHolder>(MyDiffUtil) {
    object MyDiffUtil : DiffUtil.ItemCallback<ProductsItem>(){
        override fun areItemsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
            return oldItem.id == newItem.id
        }

    }


    inner class MyViewHolder(private val binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(product: ProductsItem?) {
           binding.productPrice.text = "$"+ product?.price.toString()
            binding.productTitle.text = product?.title
            binding.productCategory.text = product?.category
            Glide.with(binding.productImageBox)
                .load(product?.image)
                .centerCrop()
                .into(binding.productImageBox)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val product = getItem(position)
        holder.bind(product)
        holder.itemView.setOnClickListener {
          val directions = HomeFragmentDirections.actionHomeFragment2ToProductDetailsFragment(product)
            it.findNavController().navigate(directions)
        }
    }



}