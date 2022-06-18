package com.example.yangiliklardasturi.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object{
      lateinit var instanse : App
      private set
    }

    override fun onCreate() {
        super.onCreate()
        instanse = this
    }
}