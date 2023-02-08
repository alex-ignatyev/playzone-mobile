package registration

sealed interface RegistrationEvent {
    data class LoginChanged(val value: String) : RegistrationEvent
    data class PasswordChanged(val value: String) : RegistrationEvent
    data class PasswordRepeatChanged(val value: String) : RegistrationEvent
    object PasswordShowClick : RegistrationEvent
    object PasswordRepeatShowClick : RegistrationEvent
    object CreateAccountClick : RegistrationEvent
}

data class RegistrationState(
    val login: String = "",
    val password: String = "",
    val passwordHidden: Boolean = true,
    val passwordRepeat: String = "",
    val passwordRepeatHidden: Boolean = true,
    val isLoading: Boolean = false
)

sealed interface RegistrationAction {
    object OnSuccessScreen : RegistrationAction
}
