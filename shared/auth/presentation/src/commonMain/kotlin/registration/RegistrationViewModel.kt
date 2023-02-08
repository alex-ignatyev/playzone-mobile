package registration

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import com.realcosmetology.android.utils.api.core.onFailure
import com.realcosmetology.android.utils.api.core.onSuccess
import di.Inject
import kotlinx.coroutines.launch

//FIXME Валидация
class RegistrationViewModel : BaseSharedViewModel<RegistrationState, RegistrationAction, RegistrationEvent>(
    initialState = RegistrationState()
) {
    private val repo: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: RegistrationEvent) {
        when (viewEvent) {
            is RegistrationEvent.CreateAccountClick -> createAccount()
            is RegistrationEvent.LoginChanged -> obtainLoginChanged(viewEvent.value)
            is RegistrationEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is RegistrationEvent.PasswordShowClick -> changePasswordVisibility()
            is RegistrationEvent.PasswordRepeatChanged -> obtainPasswordRepeatChanged(viewEvent.value)
            is RegistrationEvent.PasswordRepeatShowClick -> changePasswordRepeatVisibility()
        }
    }

    private fun createAccount() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            repo.forgotPassword(viewState.login, viewState.password).onSuccess {
                viewAction = RegistrationAction.OnSuccessScreen
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
