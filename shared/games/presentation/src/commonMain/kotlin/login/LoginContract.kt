package login

sealed interface LoginEvent {
    data class EmailChanged(val value: String) : LoginEvent
    data class PasswordChanged(val value: String) : LoginEvent
    object LoginClick : LoginEvent
    object RegistrationClick : LoginEvent
    object ForgotClick : LoginEvent
}

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isSending: Boolean = false
)

sealed interface LoginAction {
    object OpenRegistrationScreen : LoginAction
    object OpenForgotScreen : LoginAction
    object OpenMainFlow : LoginAction
}
