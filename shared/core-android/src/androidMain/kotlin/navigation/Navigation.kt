package navigation

import NavigationThree
import SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.generateGraph() {
    screen(name = NavigationThree.Splash.SplashScreen.name) {
        SplashScreen()
    }
    authFlow()
}