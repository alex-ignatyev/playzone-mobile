package util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.ramcosta.composedestinations.spec.Route
import com.ramcosta.composedestinations.utils.destination
import com.sideki.test.shared.feature.auth.compose.destinations.ForgotScreenDestination
import com.sideki.test.shared.feature.auth.compose.destinations.LoginScreenDestination
import com.sideki.test.shared.feature.auth.compose.destinations.RegistrationScreenDestination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Composable
fun NavController.appCurrentDestinationAsState(): State<Route?> {
    return appCurrentDestinationFlow.collectAsState(initial = null)
}

private val NavController.appCurrentDestinationFlow: Flow<Route>
    get() = currentBackStackEntryFlow.map { it.destination() }

fun showBar(route: Route?): Boolean {
    return when (route) {
        null, LoginScreenDestination, RegistrationScreenDestination, ForgotScreenDestination -> false
        else -> true
    }
}