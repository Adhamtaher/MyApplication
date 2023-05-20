package com.example.myapplication.common

import android.app.Application
import timber.log.Timber

class HospiApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}