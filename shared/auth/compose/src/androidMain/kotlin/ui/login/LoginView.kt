package ui.login

import Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.LoginEvent
import login.LoginState

@Composable
fun LoginView(state: LoginState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Now", color = Theme.colors.thirdTextColor,
            fontSize = 24.sp, fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back! Enter your email address and password to enjoy the latest features",
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
            placeholder = { Text("Your login", color = Theme.colors.hintTextColor) },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHandler.invoke(LoginEvent.LoginChanged(it))
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
            placeholder = { Text("Your password", color = Theme.colors.hintTextColor) },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        eventHandler.invoke(LoginEvent.PasswordShowClick)
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
                eventHandler.invoke(LoginEvent.PasswordChanged(it))
            })

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.clickable {
                    eventHandler.invoke(LoginEvent.ForgotClick)
                },
                text = "Forgot Password", color = Theme.colors.primaryAction,
                fontSize = 12.sp
            )
        }

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
                eventHandler.invoke(LoginEvent.LoginClick)
            }) {
            Text(
                "Login Now", color = Theme.colors.primaryTextColor,
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have account ?",
                color = Theme.colors.hintTextColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Create one",
                color = Theme.colors.highlightTextColor,
                modifier = Modifier.clickable {
                    eventHandler.invoke(LoginEvent.RegistrationClick)
                }
            )
        }
    }
}
