package com.s808.letsride.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LetsRideApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}