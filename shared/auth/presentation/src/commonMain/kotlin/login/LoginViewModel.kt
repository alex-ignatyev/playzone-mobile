package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import com.realcosmetology.android.utils.api.core.onFailure
import com.realcosmetology.android.utils.api.core.onSuccess
import di.Inject
import kotlinx.coroutines.launch

//FIXME Валидация
class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(
    initialState = LoginState()
) {
    private val repo: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClick -> logIn()
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.RegistrationClick -> openRegistration()
            is LoginEvent.LoginChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.PasswordShowClick -> changePasswordVisibility()
        }
    }

    private fun logIn() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            repo.logIn(viewState.login, viewState.password).onSuccess {
                viewAction = LoginAction.OpenMainFlow
            }.onFailure {
                viewState = viewState.copy(login = "", password = "", isLoading = false)
            }
        }
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotScreen
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(login = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }
}
