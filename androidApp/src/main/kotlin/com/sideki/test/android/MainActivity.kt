package com.sideki.test.android

import GamesRepository
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import di.Inject.instance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import navigation.setupThemedNavigation

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gamesRepo = instance<GamesRepository>()
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("TAG", gamesRepo.fetchAllGames().first().title)
        }
        // installSplashScreen() разобраться что это такое
        // Убрать серый сплеш через новое сплеш АПИ
        setupThemedNavigation()
    }
}
