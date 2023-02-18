import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import com.sideki.test.shared.feature.auth.compose.destinations.ForgotScreenDestination
import com.sideki.test.shared.feature.auth.compose.destinations.LoginScreenDestination
import com.sideki.test.shared.feature.auth.compose.destinations.RegistrationScreenDestination

object AuthNavGraph : NavGraphSpec {

    override val route: String = "auth"

    override val startRoute: Route = LoginScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
        LoginScreenDestination,
        RegistrationScreenDestination,
        ForgotScreenDestination
    ).associateBy { it.route }
}
