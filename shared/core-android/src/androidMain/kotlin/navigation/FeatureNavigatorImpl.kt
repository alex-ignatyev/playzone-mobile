package navigation

import FeatureNavigator
import HomeNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sideki.test.shared.feature.auth.compose.destinations.LoginScreenDestination

class FeatureNavigatorImpl(
    private val navigator: DestinationsNavigator
) : FeatureNavigator {

    override fun toMain() {
        navigator.navigate(HomeNavGraph) {
            launchSingleTop = true
            popUpTo(LoginScreenDestination.route) {
                inclusive = true
            }
        }
    }
}
