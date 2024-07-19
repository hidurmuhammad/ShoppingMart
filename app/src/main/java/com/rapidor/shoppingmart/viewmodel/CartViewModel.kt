
package com.rapidor.shoppingmart.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rapidor.shoppingmart.data.local.entity.CartEntity
import com.rapidor.shoppingmart.data.local.mappers.toCartEntity
import com.rapidor.shoppingmart.model.ProductsItem
import com.rapidor.shoppingmart.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    val cartLineItems = cartRepository.getCartLineItems()

    fun insertItemToCartLine(productItem: ProductsItem) = viewModelScope.launch {
        cartRepository.insertProductToCartLineItem(productItem.toCartEntity())  // use of mapper
    }

    fun deleteAllItemsFromCartLine() = viewModelScope.launch {
        cartRepository.deleteAllCartItems()
    }

    fun removeOnlyOneItemFromCartLine(cartEntity: CartEntity) = viewModelScope.launch {
        cartRepository.deleteAnItemFromCartLine(cartEntity)
    }

}