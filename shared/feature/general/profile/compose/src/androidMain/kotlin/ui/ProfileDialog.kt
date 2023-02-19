package ui

import Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle
import kotlinx.coroutines.delay

@Destination(style = DestinationStyle.Dialog::class)
@Composable
fun AddTaskDialog(
    navigator: DestinationsNavigator
) {
    TitleConfirmDialog(
        type = "task", //use string resources in a real app ofc :)
        title = "test",
        onTitleChange = { },
        onConfirm = {
            navigator.popBackStack()
        }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TitleConfirmDialog(
    type: String,
    title: String,
    onTitleChange: (String) -> Unit = { },
    onConfirm: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .background(Theme.colors.primaryBackground)
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Absolute.spacedBy(8.dp)
    ) {
        Text("Add a new $type:")

        OutlinedTextField(
            placeholder = { Text("${type.replaceFirstChar { it.uppercase() }} title") },
            value = title,
            onValueChange = onTitleChange,
            modifier = Modifier.focusRequester(focusRequester)
        )

        Button(
            onClick = onConfirm
        ) {
            Text("Confirm")
        }
    }

    LaunchedEffect(Unit) {
        delay(300)
        keyboardController?.show()
        focusRequester.requestFocus()
    }
}
