package ui.bottom_bar

import Theme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import navigation.RootGraph

@Composable
fun BottomNavBar(
    navController: NavHostController
) {
    BottomNavigation(
        backgroundColor = Color.Transparent
    ) {
        bottomNavItems.forEach { destination ->
            val isCurrentDestOnBackStack = navController.isRouteOnBackStack(destination.route)
            BottomNavigationItem(
                selected = isCurrentDestOnBackStack,
                selectedContentColor = Theme.colors.highlightTextColor,
                unselectedContentColor = Theme.colors.highlightTextColor.copy(alpha = ContentAlpha.disabled),
                alwaysShowLabel = false,
                icon = {
                    AnimatedBottomNavIcon(
                        imageVector = if (isCurrentDestOnBackStack) destination.iconSelected else destination.icon,
                        scale = if (isCurrentDestOnBackStack) 1.5f else 1f,
                        color = if (isCurrentDestOnBackStack) Theme.colors.highlightTextColor else Theme.colors.highlightTextColor.copy(
                            alpha = ContentAlpha.disabled
                        )
                    )
                },
                label = { Text(text = destination.title, fontSize = 8.sp)},
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
                }
            )
        }
    }
}
