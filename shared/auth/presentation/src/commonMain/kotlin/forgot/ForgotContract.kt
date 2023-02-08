package forgot

sealed interface ForgotEvent {
    data class LoginChanged(val value: String) : ForgotEvent
    data class PasswordChanged(val value: String) : ForgotEvent
    data class PasswordRepeatChanged(val value: String) : ForgotEvent
    object PasswordShowClick : ForgotEvent
    object PasswordRepeatShowClick : ForgotEvent
    object ChangePasswordClick : ForgotEvent
}

data class ForgotState(
    val login: String = "",
    val password: String = "",
    val passwordHidden: Boolean = true,
    val passwordRepeat: String = "",
    val passwordRepeatHidden: Boolean = true,
    val isLoading: Boolean = false
)

sealed interface ForgotAction {
    object OpenLoginScreen : ForgotAction
}
