import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import com.sideki.test.shared.feature.general.profile.compose.destinations.AddTaskDialogDestination
import com.sideki.test.shared.feature.general.profile.compose.destinations.BottomSheetDestination
import com.sideki.test.shared.feature.general.profile.compose.destinations.ProfileScreenDestination

object ProfileNavGraph : NavGraphSpec {

    override val route: String = "profile"

    override val startRoute: Route = ProfileScreenDestination

    override val destinationsByRoute: Map<String, DestinationSpec<*>> = listOf(
        ProfileScreenDestination,
        AddTaskDialogDestination,
        BottomSheetDestination
    ).associateBy { it.route }
}
