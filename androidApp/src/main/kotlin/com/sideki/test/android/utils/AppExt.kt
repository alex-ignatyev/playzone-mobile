package com.sideki.test.android.utils

import PlatformSDK
import com.sideki.test.android.App
import platform.PlatformConfiguration

fun App.initPlatformSDK() =
    PlatformSDK.init(
        configuration = PlatformConfiguration(androidContext = applicationContext)
    )
