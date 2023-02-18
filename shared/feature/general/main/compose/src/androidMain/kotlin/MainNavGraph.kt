import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import com.sideki.test.shared.feature.general.main.compose.destinations.MainScreenDestination
import com.sideki.test.shared.feature.general.main.compose.destinations.ProfileScreenDestination

object MainNavGraph : NavGraphSpec {

    override val route: String = "main"

    override val startRoute: Route = MainScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
        MainScreenDestination
    ).associateBy { it.route }
}

object ProfileNavGraph : NavGraphSpec {

    override val route: String = "profile"

    override val startRoute: Route = ProfileScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
        ProfileScreenDestination
    ).associateBy { it.route }
}
