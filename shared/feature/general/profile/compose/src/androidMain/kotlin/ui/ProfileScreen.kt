package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sideki.test.shared.feature.general.profile.compose.destinations.AddTaskDialogDestination
import com.sideki.test.shared.feature.general.profile.compose.destinations.BottomSheetDestination

@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Button(onClick = {
                navigator.navigate(AddTaskDialogDestination)
            }) {
                Text(text = "Dialog")
            }
            Button(onClick = {
                navigator.navigate(BottomSheetDestination)
            }) {
                Text(text = "BottomSheet")
            }
        }
    }
}
