package navigation

import NavigationThree
import ui.forgot.ForgotScreen
import ui.login.LoginScreen
import ui.registration.RegistrationScreen
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