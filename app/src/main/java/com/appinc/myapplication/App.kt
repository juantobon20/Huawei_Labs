package com.appinc.myapplication

import android.app.Application
import com.huawei.hms.maps.MapsInitializer

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MapsInitializer.initialize(applicationContext)
    }
}