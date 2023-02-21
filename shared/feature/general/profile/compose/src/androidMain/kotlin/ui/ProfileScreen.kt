package ui

import ProfileAction
import ProfileViewModel
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sideki.test.shared.feature.general.profile.compose.destinations.AddTaskDialogDestination
import com.sideki.test.shared.feature.general.profile.compose.destinations.BottomSheetDestination

@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {
    ViewModel(factory = { ProfileViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        ProfileView(state = state.value, eventHandler = {
            viewModel.obtainEvent(it)
        })

        when (action.value) {
            is ProfileAction.LoggOut -> navigator.navigate(AddTaskDialogDestination)
            is ProfileAction.OpenBottomSheet -> navigator.navigate(BottomSheetDestination)
            else -> Unit
        }
    }
}
