package com.example.safracafe

import android.app.Application
import com.example.safracafe.data.AppContainer
import com.example.safracafe.data.AppDataContainer

class SafraCafeApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}