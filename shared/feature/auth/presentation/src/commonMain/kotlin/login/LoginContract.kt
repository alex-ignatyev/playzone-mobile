package login

sealed interface LoginEvent {
    data class LoginChanged(val value: String) : LoginEvent
    data class PasswordChanged(val value: String) : LoginEvent
    object PasswordShowClick : LoginEvent
    object LoginClick : LoginEvent
    object RegistrationClick : LoginEvent
    object ForgotClick : LoginEvent

    object TestLoginClick : LoginEvent
}

data class LoginState(
    val login: String = "",
    val password: String = "",
    val passwordHidden: Boolean = true,
    val isLoading: Boolean = false
)

sealed interface LoginAction {
    object OpenRegistrationScreen : LoginAction
    object OpenForgotScreen : LoginAction
    object OpenMainFlow : LoginAction
}
