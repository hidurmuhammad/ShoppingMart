
package com.rapidor.shoppingmart.api

import com.rapidor.shoppingmart.model.ProductsItem
import retrofit2.http.GET

interface ApiService {

   // fetch resource from the network
   // This function returns the requestType
   @GET("products")
   suspend fun getProducts() : ArrayList<ProductsItem>

}