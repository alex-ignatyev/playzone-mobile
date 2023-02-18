package navigation

import AuthNavGraph
import HomeNavGraph
import ProfileNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object RootGraph : NavGraphSpec {

    override val route = "root"

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val startRoute = HomeNavGraph

    override val nestedNavGraphs = listOf(
        AuthNavGraph,
        HomeNavGraph,
        ProfileNavGraph
    )
}
