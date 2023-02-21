sealed class ProfileEvent {
    object OnLoggOut : ProfileEvent()
    object OnBottomSheetOpen : ProfileEvent()
}

data class ProfileState(
    val isLoading: Boolean = false
)

sealed class ProfileAction {
    object LoggOut : ProfileAction()
    object OpenBottomSheet : ProfileAction()
}
