package ui.forgot

import AppTheme
import Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockOpen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import forgot.ForgotEvent
import forgot.ForgotState

@Composable
fun ForgotView(state: ForgotState, eventHandler: (ForgotEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Forgot Password", color = Theme.colors.thirdTextColor,
            fontSize = 24.sp, fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Enter right Login and change your password",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Theme.colors.hintTextColor
        )

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = state.login,
            enabled = !state.isLoading,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Theme.colors.backgroundTextField,
                textColor = Theme.colors.hintTextColor,
                cursorColor = Theme.colors.highlightTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = { Text("Login", color = Theme.colors.hintTextColor) },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHandler.invoke(ForgotEvent.LoginChanged(it))
            })

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = state.password,
            enabled = !state.isLoading,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Theme.colors.backgroundTextField,
                textColor = Theme.colors.hintTextColor,
                cursorColor = Theme.colors.highlightTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if (state.passwordHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            placeholder = { Text("New password", color = Theme.colors.hintTextColor) },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        eventHandler.invoke(ForgotEvent.PasswordShowClick)
                    },
                    imageVector = if (state.passwordHidden) {
                        Icons.Outlined.Lock
                    } else {
                        Icons.Outlined.LockOpen
                    },
                    contentDescription = "Password hidden",
                    tint = Theme.colors.hintTextColor
                )
            },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHandler.invoke(ForgotEvent.PasswordChanged(it))
            })

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = state.passwordRepeat,
            enabled = !state.isLoading,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Theme.colors.backgroundTextField,
                textColor = Theme.colors.hintTextColor,
                cursorColor = Theme.colors.highlightTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if (state.passwordRepeatHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            placeholder = { Text("Repeat new password", color = Theme.colors.hintTextColor) },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        eventHandler.invoke(ForgotEvent.PasswordRepeatShowClick)
                    },
                    imageVector = if (state.passwordRepeatHidden) {
                        Icons.Outlined.Lock
                    } else {
                        Icons.Outlined.LockOpen
                    },
                    contentDescription = "Password hidden",
                    tint = Theme.colors.hintTextColor
                )
            },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHandler.invoke(ForgotEvent.PasswordRepeatChanged(it))
            })

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isLoading,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                eventHandler.invoke(ForgotEvent.ChangePasswordClick)
            }) {
            Text(
                "Change Password", color = Theme.colors.primaryTextColor,
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF050B18)
@Composable
fun Preview_ForgotView() {
    AppTheme {
        ForgotView(ForgotState()) {}
    }
}
