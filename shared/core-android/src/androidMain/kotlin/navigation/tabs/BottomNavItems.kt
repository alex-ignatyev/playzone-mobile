package navigation.tabs

import MainNavGraph
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.Route
import com.sideki.test.shared.feature.general.main.compose.destinations.MainScreenDestination
import com.sideki.test.shared.feature.general.main.compose.destinations.ProfileScreenDestination

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
    route = MainNavGraph
)

object Profile : BottomNavItem(
    title = "Profile",
    icon = Icons.Outlined.Person,
    iconSelected = Icons.Default.Person,
    route = ProfileScreenDestination
)
