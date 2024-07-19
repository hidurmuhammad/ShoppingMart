package com.rapidor.shoppingmart.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rapidor.shoppingmart.data.local.entity.CartEntity
import com.rapidor.shoppingmart.databinding.CartItemBinding

class CartAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<CartEntity, CartAdapter.CartViewHolder>(CartDiffUtil) {
    object CartDiffUtil : DiffUtil.ItemCallback<CartEntity>() {
        override fun areItemsTheSame(oldItem: CartEntity, newItem: CartEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CartEntity, newItem: CartEntity): Boolean {
            return oldItem.id == newItem.id
        }

    }

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var count = 1
        val deleteItemFromCartLine = binding.buttonRemoveCartItem

        @SuppressLint("SetTextI18n")
        fun bind(cartLineItem: CartEntity?) {
            Glide.with(binding.imageView3).load(cartLineItem?.image)
                .centerCrop()
                .fitCenter()
                .into(binding.imageView3)

            binding.textViewProductName.text = cartLineItem?.title
            binding.textView2.text = "$" + cartLineItem?.price.toString()

            binding.buttonIncrease.setOnClickListener {
                count += 1
                binding.textView3.text = count.toString()
            }
            binding.buttonDecrease.setOnClickListener {
                count -= 1
                if (count >= 1) {
                    binding.textView3.text = count.toString()
                }else{
                    count = 1
                    binding.textView3.text = count.toString()
                }
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartLineItem = getItem(position)
        holder.bind(cartLineItem)

        holder.deleteItemFromCartLine.setOnClickListener {
            onClickListener.onClick(cartLineItem)
        }
    }

    class OnClickListener(val clickListener: (cart: CartEntity) -> Unit) {
        fun onClick(cart: CartEntity) = clickListener(cart)
    }

}