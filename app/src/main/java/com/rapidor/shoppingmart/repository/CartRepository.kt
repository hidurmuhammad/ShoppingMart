
package com.rapidor.shoppingmart.repository

import androidx.lifecycle.LiveData
import com.rapidor.shoppingmart.data.local.ProductsDatabase
import com.rapidor.shoppingmart.data.local.entity.CartEntity

class CartRepository (
     private val database: ProductsDatabase
        ) {

    suspend fun deleteAllCartItems() {
        database.cartDao().deleteAllCartItems()
    }

    suspend fun insertProductToCartLineItem(cartEntity: CartEntity) {
        database.cartDao().insertToCartLineItem(cartEntity)
    }

    suspend fun deleteAnItemFromCartLine(cartEntity: CartEntity) {
        database.cartDao().deleteAnItemFromCart(cartEntity)
    }

    fun getCartLineItems() : LiveData<List<CartEntity>> {
       return database.cartDao().getCartItems()
    }

    fun getOnlyOneCartLineItem(id:Int) : LiveData<CartEntity?> {
        return database.cartDao().getOneCartItem(id)
    }





}