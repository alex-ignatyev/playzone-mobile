package ui.registration

import Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import registration.RegistrationEvent
import registration.RegistrationState

@Composable
fun RegistrationView(state: RegistrationState, eventHandler: (RegistrationEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create an Account", color = Theme.colors.thirdTextColor,
            fontSize = 24.sp, fontWeight = FontWeight.Bold
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
                eventHandler.invoke(RegistrationEvent.LoginChanged(it))
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
            placeholder = { Text("Password", color = Theme.colors.hintTextColor) },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        eventHandler.invoke(RegistrationEvent.PasswordShowClick)
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
                eventHandler.invoke(RegistrationEvent.PasswordChanged(it))
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
            placeholder = { Text("Repeat password", color = Theme.colors.hintTextColor) },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        eventHandler.invoke(RegistrationEvent.PasswordRepeatShowClick)
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
                eventHandler.invoke(RegistrationEvent.PasswordRepeatChanged(it))
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
                eventHandler.invoke(RegistrationEvent.CreateAccountClick)
            }) {
            Text(
                "Create Account", color = Theme.colors.primaryTextColor,
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}
