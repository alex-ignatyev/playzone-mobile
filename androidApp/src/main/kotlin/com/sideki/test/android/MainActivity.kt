package com.sideki.test.android

import AuthRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import di.Inject
import kotlinx.coroutines.runBlocking
import navigation.setupThemedNavigation

class MainActivity : ComponentActivity() {

    private val repo: AuthRepository = Inject.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        super.onCreate(savedInstanceState)
        splash.setKeepOnScreenCondition { checkToken() } // Сплеш скроет после того как вся работа будет выполнена и вернется false
    }

    private fun checkToken(): Boolean {
        return runBlocking {
            setupThemedNavigation(repo.authenticate().isSuccess)
            false
        }
    }
}
