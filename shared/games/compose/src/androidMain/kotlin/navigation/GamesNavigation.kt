package navigation

import NavigationThree
import forgot.ForgotScreen
import login.LoginScreen
import registration.RegistrationScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.authFlow() {
    flow(name = NavigationThree.Games.AuthFlow.name) {
        screen(name = NavigationThree.Games.Login.name) {
            LoginScreen()
        }

        screen(name = NavigationThree.Games.Register.name) {
            RegistrationScreen()
        }

        screen(name = NavigationThree.Games.Forgot.name) {
            ForgotScreen()
        }
    }
}