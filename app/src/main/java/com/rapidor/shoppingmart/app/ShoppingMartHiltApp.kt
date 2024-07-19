package com.rapidor.shoppingmart.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ShoppingMartHiltApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Timber for logging
        getTimber()
    }

    private fun getTimber() {
        Timber.plant(Timber.DebugTree())
    }
}