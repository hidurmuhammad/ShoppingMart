
package com.rapidor.shoppingmart.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rapidor.shoppingmart.data.local.entity.CartEntity
import com.rapidor.shoppingmart.model.ProductsItem


/*
*  The Schema of room Database changes when more entities are added
* to the database
 */
@Database(exportSchema = false, version = 2, entities = [ProductsItem::class, CartEntity::class])
@TypeConverters
abstract class ProductsDatabase : RoomDatabase() {

    // calling ProductsDao
    abstract fun productsDao(): ProductsDao

    // calling CartDao
    abstract fun cartDao(): CartDao

}