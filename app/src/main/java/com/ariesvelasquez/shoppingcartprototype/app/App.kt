package com.ariesvelasquez.shoppingcartprototype.app

import android.app.Application
import com.ariesvelasquez.shoppingcartprototype.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}