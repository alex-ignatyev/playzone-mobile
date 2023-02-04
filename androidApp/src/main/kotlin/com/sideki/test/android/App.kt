package com.sideki.test.android

import android.app.Application
import com.sideki.test.android.utils.initPlatformSDK

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }
}
