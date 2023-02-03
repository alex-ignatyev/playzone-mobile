package navigation

import AppTheme
import NavigationThree
import Theme
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator

fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph() }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()

    setContent {
        AppTheme {
            val backgroundColor = Theme.colors.primaryBackground
            rootController.backgroundColor = backgroundColor

            CompositionLocalProvider(LocalRootController provides rootController) {
                ModalNavigator {
                    Navigator(startScreen = NavigationThree.Splash.SplashScreen.name)
                }
            }
        }
    }
}