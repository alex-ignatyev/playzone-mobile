package ui.registration

import NavigationThree
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import registration.RegistrationAction
import registration.RegistrationViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag

@Composable
fun RegistrationScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { RegistrationViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        RegistrationView(state = state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            is RegistrationAction.OnSuccessScreen -> rootController.push(
                screen = NavigationThree.Auth.Login.name,
                launchFlag = LaunchFlag.SingleNewTask
            )
            else -> Unit
        }
    }
}
