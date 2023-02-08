package ui.forgot

import NavigationThree
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import forgot.ForgotAction
import forgot.ForgotViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag

@Composable
fun ForgotScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { ForgotViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        ForgotView(state = state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            is ForgotAction.OpenLoginScreen -> rootController.push(
                screen = NavigationThree.Auth.Login.name,
                launchFlag = LaunchFlag.SingleNewTask
            )
            else -> Unit
        }
    }
}
