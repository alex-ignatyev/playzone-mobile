package navigation

import NavigationThree
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import navigation.tabs.BottomConfiguration
import navigation.tabs.HomeTab
import navigation.tabs.ProfileTab
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.generateGraph() {
    authFlow()
    generalFlow()
}

fun RootComposeBuilder.generalFlow() {
    bottomNavigation(
        name = NavigationThree.General.Main.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavigationThree.General.Home.name) {
                Text(
                    "Hello, Main", modifier = Modifier.fillMaxSize(),
                    color = Color.White
                )
            }

            //Табы внутри
            /*screen(name = NavigationThree.General.Profile.name) {
                Text("Hello, Profile")
            }*/
        }

        tab(ProfileTab()) {
            screen(name = NavigationThree.General.Profile.name) {
                Text(
                    "Hello, Profile", modifier = Modifier.fillMaxSize(),
                    color = Color.White
                )
            }
        }
    }
}
