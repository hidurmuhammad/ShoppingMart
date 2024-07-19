package com.rapidor.shoppingmart.di

import com.rapidor.shoppingmart.api.ApiService
import com.rapidor.shoppingmart.data.local.ProductsDatabase
import com.rapidor.shoppingmart.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService,
                           productsDatabase: ProductsDatabase
    ) : ProductsRepository {
        return ProductsRepository(apiService, productsDatabase)
    }
}