import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import com.sideki.test.shared.feature.general.home.compose.destinations.HomeScreen2Destination
import com.sideki.test.shared.feature.general.home.compose.destinations.HomeScreen3Destination
import com.sideki.test.shared.feature.general.home.compose.destinations.HomeScreenDestination

object HomeNavGraph : NavGraphSpec {

    override val route: String = "home"

    override val startRoute: Route = HomeScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
        HomeScreenDestination,
        HomeScreen2Destination,
        HomeScreen3Destination
    ).associateBy { it.route }
}
