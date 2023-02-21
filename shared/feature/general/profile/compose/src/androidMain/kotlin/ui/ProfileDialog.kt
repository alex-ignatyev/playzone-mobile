package ui

import AppTheme
import Theme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(style = DestinationStyle.Dialog::class)
@Composable
fun AddTaskDialog(
    navigator: DestinationsNavigator
) {
    TitleConfirmDialog(
        onLogOut = {

        },
        onCancel = {
            navigator.popBackStack()
        }
    )
}

@Composable
fun TitleConfirmDialog(
    onLogOut: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .height(120.dp)
            .wrapContentWidth()
            .background(Theme.colors.primaryBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Absolute.spacedBy(8.dp)
    ) {
        Text(text = "Are you sure ?", color = Theme.colors.secondaryTextColor, fontSize = 20.sp)

        Row {
            OutlinedButton(
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(2.dp, Theme.colors.hintTextColor),
                shape = RoundedCornerShape(10.dp),
                onClick = onCancel
            ) {
                Text(
                    "Cancel",
                    color = Theme.colors.hintTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Theme.colors.primaryAction
                ),
                shape = RoundedCornerShape(10.dp),
                onClick = onLogOut
            ) {
                Text(
                    "Log Out",
                    color = Theme.colors.primaryTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF050B18)
@Composable
fun Preview_TitleConfirmDialog() {
    AppTheme {
        TitleConfirmDialog({}, {})
    }
}
