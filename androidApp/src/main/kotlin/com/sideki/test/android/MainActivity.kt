package com.sideki.test.android

import GamesRepository
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import di.Inject.instance
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
        val gamesRepo = instance<GamesRepository>()
        Log.d("TAG", gamesRepo.fetchAllGames().first().title)
        Log.d("TAG", "End")
        false
    }
}
