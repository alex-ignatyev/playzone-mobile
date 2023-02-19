package ui.bottom_bar

import HomeNavGraph
import ProfileNavGraph
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.spec.Route

val bottomNavItems = listOf(Home, Profile)

open class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val route: Route
)

object Home : BottomNavItem(
    title = "Home",
    icon = Icons.Outlined.Home,
    iconSelected = Icons.Default.Home,
    route = HomeNavGraph
)

object Profile : BottomNavItem(
    title = "Profile",
    icon = Icons.Outlined.Person,
    iconSelected = Icons.Default.Person,
    route = ProfileNavGraph
)

fun BottomNavItem.direction(): Direction =
    when (this) {
        is Home -> HomeNavGraph
        is Profile -> ProfileNavGraph
        else -> throw IllegalStateException("Unknown direction")
    }
