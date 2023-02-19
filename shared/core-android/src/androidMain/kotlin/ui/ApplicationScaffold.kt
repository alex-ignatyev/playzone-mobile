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

    // Необходимо для отображения BottomSheet - возможно стоит заменить на https://proandroiddev.com/bottom-sheet-in-jetpack-compose-d7e106422606
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Scaffold(
            topBar = topBar,
            bottomBar = { bottomBar(destination) },
            backgroundColor = Theme.colors.primaryBackground,
            content = content
        )
    }
}
