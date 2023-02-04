package login

import NavigationThree
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        LoginView(state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            is LoginAction.OpenMainFlow -> {
                /*rootController.findRootController()
                    .present(
                        screen = NavigationThree.Main.Dashboard.name,
                        launchFlag = LaunchFlag.SingleNewTask
                    )*/
            }

            is LoginAction.OpenRegistrationScreen -> rootController.push(
                NavigationThree.Auth.Register.name
            )

            is LoginAction.OpenForgotScreen -> rootController.push(
                NavigationThree.Auth.Forgot.name
            )

            null -> {}
        }
    }
}
