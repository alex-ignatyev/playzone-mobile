package ui.registration

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import com.ramcosta.composedestinations.annotation.Destination
import registration.RegistrationAction
import registration.RegistrationViewModel

@Destination
@Composable
fun RegistrationScreen() {
    ViewModel(factory = { RegistrationViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        RegistrationView(state = state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            is RegistrationAction.OnSuccessScreen -> {}
            else -> Unit
        }
    }
}
