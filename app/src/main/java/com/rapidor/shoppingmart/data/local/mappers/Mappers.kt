package com.rapidor.shoppingmart.data.local.mappers

import com.rapidor.shoppingmart.data.local.entity.CartEntity
import com.rapidor.shoppingmart.model.ProductsItem

/* Maps a data class into other data classes
*
* We are mapping ProductItem data class into CartEntity data class
* */

fun ProductsItem.toCartEntity() : CartEntity {
    return CartEntity(
        image = image,
        title = title,
        description = description,
        category = category,
        price = price
    )
}