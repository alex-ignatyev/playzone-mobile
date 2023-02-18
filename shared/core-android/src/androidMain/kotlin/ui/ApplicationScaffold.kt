package ui

import Theme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.spec.Route
import util.appCurrentDestinationAsState
import util.showBottomNavBar

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun ApplicationScaffold(
    startRoute: Route,
    navController: NavHostController,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable (Route) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value ?: startRoute

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    // Необходимо для отображения BottomSheet
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(16.dp)
    ) {
        Scaffold(
            topBar = topBar,
            bottomBar = { if (showBottomNavBar(destination)) bottomBar(destination) },
            backgroundColor = Theme.colors.primaryBackground,
            content = content
        )
    }
}
