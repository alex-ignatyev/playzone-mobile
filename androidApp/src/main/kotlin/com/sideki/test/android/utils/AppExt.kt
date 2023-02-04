package com.sideki.test.android.utils

import AndroidPlatformSDK
import com.sideki.test.android.App
import platform.PlatformConfiguration

fun App.initPlatformSDK() =
    AndroidPlatformSDK.init(
        configuration = PlatformConfiguration(androidContext = applicationContext)
    )
