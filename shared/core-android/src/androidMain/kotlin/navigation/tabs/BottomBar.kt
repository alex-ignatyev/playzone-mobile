package navigation.tabs

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import com.sideki.test.shared.feature.general.main.compose.destinations.MainScreenDestination
import com.sideki.test.shared.feature.general.main.compose.destinations.ProfileScreenDestination
import navigation.RootGraph

@Composable
fun BottomBar(
    navController: NavHostController
) {
    BottomNavigation {
        bottomNavItems.forEach { destination ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(destination.route)
            BottomNavigationItem(
                selected = isCurrentDestOnBackStack,
                onClick = {
                    if (isCurrentDestOnBackStack) {
                        // When we click again on a bottom bar item and it was already selected
                        // we want to pop the back stack until the initial destination of this bottom bar item
                        navController.popBackStack(destination.route.route, false)
                        return@BottomNavigationItem
                    }

                    navController.navigate(destination.direction()) {
                        // Pop up to the root of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(RootGraph.route) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        if (isCurrentDestOnBackStack) destination.iconSelected else destination.icon,
                        contentDescription = destination.title
                    )
                },
                label = { Text(destination.title) },
            )
        }
    }
}

private fun BottomNavItem.direction(): Direction =
    when (this) {
        is Home -> MainScreenDestination
        is Profile -> ProfileScreenDestination
        else -> throw IllegalStateException("Unknown direction")
    }