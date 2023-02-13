package forgot

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import api.core.onFailure
import api.core.onSuccess
import di.Inject
import kotlinx.coroutines.launch

//FIXME Валидация
class ForgotViewModel : BaseSharedViewModel<ForgotState, ForgotAction, ForgotEvent>(
    initialState = ForgotState()
) {
    private val repo: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: ForgotEvent) {
        when (viewEvent) {
            is ForgotEvent.ChangePasswordClick -> changePassword()
            is ForgotEvent.LoginChanged -> obtainLoginChanged(viewEvent.value)
            is ForgotEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is ForgotEvent.PasswordShowClick -> changePasswordVisibility()
            is ForgotEvent.PasswordRepeatChanged -> obtainPasswordRepeatChanged(viewEvent.value)
            is ForgotEvent.PasswordRepeatShowClick -> changePasswordRepeatVisibility()
        }
    }

    private fun changePassword() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            repo.forgotPassword(viewState.login, viewState.password).onSuccess {
                viewAction = ForgotAction.OpenLoginScreen
            }.onFailure {
                viewState = viewState.copy(login = "", password = "", passwordRepeat = "", isLoading = false)
            }
        }
    }

    private fun obtainLoginChanged(value: String) {
        viewState = viewState.copy(login = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun obtainPasswordRepeatChanged(value: String) {
        viewState = viewState.copy(passwordRepeat = value)
    }

    private fun changePasswordRepeatVisibility() {
        viewState = viewState.copy(passwordRepeatHidden = !viewState.passwordRepeatHidden)
    }
}
