package com.rapidor.shoppingmart.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.rapidor.shoppingmart.koin.repoModule
import com.rapidor.shoppingmart.koin.retrofitModule
import com.rapidor.shoppingmart.koin.retrofitModule2
import com.rapidor.shoppingmart.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ShoppingMartKoinApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@ShoppingMartKoinApp)
            // use Android logger - Level.INFO by default
            androidLogger()
            modules(
                listOf(
                    retrofitModule,
                    viewModelModule,
                    retrofitModule2,
                    repoModule
                )
            )
        }
    }
    //Setup the multiDex
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}