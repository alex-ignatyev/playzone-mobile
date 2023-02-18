package ui.forgot

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import com.ramcosta.composedestinations.annotation.Destination
import forgot.ForgotAction
import forgot.ForgotViewModel

@Destination
@Composable
fun ForgotScreen() {
    ViewModel(factory = { ForgotViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        ForgotView(state = state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            is ForgotAction.OpenLoginScreen -> {}
            else -> Unit
        }
    }
}
