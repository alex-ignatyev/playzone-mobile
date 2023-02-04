package navigation

import NavigationThree
import forgot.ForgotScreen
import login.LoginScreen
import registration.RegistrationScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.authFlow() {
    flow(name = NavigationThree.Auth.AuthFlow.name) {
        screen(name = NavigationThree.Auth.Login.name) {
            LoginScreen()
        }

        screen(name = NavigationThree.Auth.Register.name) {
            RegistrationScreen()
        }

        screen(name = NavigationThree.Auth.Forgot.name) {
            ForgotScreen()
        }
    }
}