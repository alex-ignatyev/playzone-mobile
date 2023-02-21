package ui

import AppTheme
import ProfileEvent
import ProfileState
import Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockOpen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileView(state: ProfileState, eventHandler: (ProfileEvent) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My profile",
                    modifier = Modifier.weight(1f),
                    color = Theme.colors.thirdTextColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Image(
                    imageVector = Icons.Default.Logout,
                    colorFilter = ColorFilter.tint(Theme.colors.highlightTextColor),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        eventHandler.invoke(ProfileEvent.OnLoggOut)
                    }
                )
            }

            Row(
                modifier = Modifier.padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.Person,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = null,
                    modifier = Modifier
                        .size(84.dp)
                        .clickable {
                            eventHandler.invoke(ProfileEvent.OnLoggOut)
                        }
                )

                Spacer(modifier = Modifier.width(24.dp))

                Column {
                    Text(text = "Erlink Halah", color = Theme.colors.secondaryTextColor, fontSize = 20.sp)
                    Text(text = "erlinkland@gmail.com", color = Theme.colors.secondaryTextColor, fontSize = 12.sp)
                    Text(text = "ID: 1234567", color = Theme.colors.hintTextColor, fontSize = 10.sp)
                }
            }

            Column(
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text(
                    text = "Full name",
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Theme.colors.hintTextColor,
                    fontSize = 14.sp
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    value = "state.login",
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

                    })

                Text(
                    text = "Email address",
                    modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
                    color = Theme.colors.hintTextColor,
                    fontSize = 14.sp
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    value = "state.login",
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

                    })

                Text(
                    text = "Password",
                    modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
                    color = Theme.colors.hintTextColor,
                    fontSize = 14.sp
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    value = "state.password",
                    enabled = !state.isLoading,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Theme.colors.backgroundTextField,
                        textColor = Theme.colors.hintTextColor,
                        cursorColor = Theme.colors.highlightTextColor,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = if (true /*state.passwordHidden*/) {
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

                            },
                            imageVector = if (true /*state.passwordHidden*/) {
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

                    })
            }

            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
                Column {
                    Button(onClick = {
                        eventHandler.invoke(ProfileEvent.OnBottomSheetOpen)
                    }) {
                        Text(text = "BottomSheet")
                    }

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
                        }) {
                        Text(
                            "Save Changes", color = Theme.colors.primaryTextColor,
                            fontSize = 16.sp, fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF050B18)
@Composable
fun Preview_ProfileView() {
    AppTheme {
        ProfileView(ProfileState()) {}
    }
}
