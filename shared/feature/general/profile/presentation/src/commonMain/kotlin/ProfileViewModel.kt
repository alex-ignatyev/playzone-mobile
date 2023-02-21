import com.adeo.kviewmodel.BaseSharedViewModel

class ProfileViewModel : BaseSharedViewModel<ProfileState, ProfileAction, ProfileEvent>(
    initialState = ProfileState()
) {

    override fun obtainEvent(viewEvent: ProfileEvent) {
        viewAction = when (viewEvent) {
            ProfileEvent.OnLoggOut -> ProfileAction.LoggOut
            ProfileEvent.OnBottomSheetOpen -> ProfileAction.OpenBottomSheet
        }
    }
}
