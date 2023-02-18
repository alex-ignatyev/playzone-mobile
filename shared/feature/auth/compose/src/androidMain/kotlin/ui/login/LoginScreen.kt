package ui.login

import FeatureNavigator
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sideki.test.shared.feature.auth.compose.destinations.ForgotScreenDestination
import com.sideki.test.shared.feature.auth.compose.destinations.RegistrationScreenDestination
import login.LoginAction
import login.LoginViewModel

@Destination(start = true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    featureNavigator: FeatureNavigator
) {
    ViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        LoginView(state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            is LoginAction.OpenMainFlow -> featureNavigator.toMain()
            is LoginAction.OpenRegistrationScreen -> navigator.navigate(RegistrationScreenDestination)
            is LoginAction.OpenForgotScreen -> navigator.navigate(ForgotScreenDestination)
            else -> Unit
        }
    }
}
