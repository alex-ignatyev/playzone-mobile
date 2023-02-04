package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject

class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(
    initialState = LoginState()
) {
    private val repo: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.RegistrationClick -> openRegistration()
        }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotScreen
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenForgotScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }
}