package com.rapidor.shoppingmart.repository

import androidx.room.withTransaction
import com.rapidor.shoppingmart.api.ApiService
import com.rapidor.shoppingmart.data.local.ProductsDatabase
import com.rapidor.shoppingmart.model.ProductsItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import networkBoundResource
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val apiService: ApiService,
    private val productsDatabase: ProductsDatabase
){

    private val productDao = productsDatabase.productsDao()

    fun getAllProducts() = networkBoundResource(

        // Logic to query data from database - [offline cache storage]
        // Querying cached data from the local db
        query = {
            productDao.getAllProducts()
        },

        // Logic to fetch data from the api
        fetch = {
            delay(2000)
            apiService.getProducts()
        },

        // Logic to save the fetched resultType data from api to the local db
        saveFetchResult = { products ->
            productsDatabase.withTransaction {
                productDao.deleteAllProducts()
                productDao.insertProducts(products)
            }
        },

        // Logic to determine if networking call should be made
        shouldFetch = { products ->
            products.isEmpty()
        }

    )

    // fetching products from the remote api web service


    fun searchDatabase(searchQuery: String) : Flow<List<ProductsItem>> {
        return productDao.searchDatabase(searchQuery)
    }
}