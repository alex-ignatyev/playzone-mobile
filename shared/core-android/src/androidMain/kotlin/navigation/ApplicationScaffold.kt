package navigation

import Theme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.spec.Route
import com.ramcosta.composedestinations.utils.destination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun ApplicationScaffold(
    startRoute: Route,
    navController: NavHostController,
    bottomBar: @Composable (Route) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value ?: startRoute

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    // 👇 ModalBottomSheetLayout is only needed if some destination is bottom sheet styled
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(16.dp)
    ) {
        Scaffold(
            topBar = { },
            bottomBar = { bottomBar(destination) },
            backgroundColor = Theme.colors.primaryBackground,
            content = content
        )
    }
}

public fun NavBackStackEntry.appDestination(): Route {
    return destination() as Route
}

/**
 * Emits the currently active [Destination] whenever it changes. If
 * there is no active [Destination], no item will be emitted.
 */
public val NavController.appCurrentDestinationFlow: Flow<Route>
    get() = currentBackStackEntryFlow.map { it.appDestination() }

/**
 * Gets the current [Destination] as a [State].
 */
@Composable
public fun NavController.appCurrentDestinationAsState(): State<Route?> {
    return appCurrentDestinationFlow.collectAsState(initial = null)
}