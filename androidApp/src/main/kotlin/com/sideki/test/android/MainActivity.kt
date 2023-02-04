package com.sideki.test.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import navigation.setupThemedNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        super.onCreate(savedInstanceState)
        splash.setKeepOnScreenCondition { testSplashWorks() } // Сплеш скроет после того как вся работа будет выполнена и вернется false
        setupThemedNavigation()
    }
}

fun testSplashWorks(): Boolean {
    return runBlocking {
        Log.d("TAG", "Start")
        delay(2000)
        Log.d("TAG", "End")
        false
    }
}
