import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navigation.dependency
import com.sideki.test.shared.feature.auth.compose.destinations.LoginScreenDestination
import navigation.FeatureNavigatorImpl
import navigation.RootGraph
import ui.ApplicationScaffold
import ui.bottom_bar.BottomNavBar
import util.appCurrentDestinationAsState
import util.showBar

//TODO добавить тулбар как в репе
//TODO Добавить логаут
//TODO перенести проверку токена на меин
//TODO Почитать еще про либу нава
//TODO Поднять котлин до 1/8 и внести все правки
//TODO убрать все манифесты
//TODO бурать тень у боттом нав бара

fun ComponentActivity.setupThemedNavigation(isAuthorised: Boolean) {
    setContent {
        AppTheme {
            App(isAuthorised)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
fun App(isAuthorised: Boolean) {
    val engine = rememberAnimatedNavHostEngine()
    val navController = engine.rememberNavController()
    val startRoute = if (!isAuthorised) AuthNavGraph else HomeNavGraph
    val destination = navController.appCurrentDestinationAsState().value

    ApplicationScaffold(
        startRoute = startRoute,
        navController = navController,
        bottomBar = { if (showBar(destination)) BottomNavBar(navController) }
    ) {
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = RootGraph,
            startRoute = AuthNavGraph,
            dependenciesContainerBuilder = {
                addDependencies(FeatureNavigatorImpl(destinationsNavigator))
            },
            modifier = Modifier.padding(it),
        )
    }
}

// Возможно стоит упростить
private fun DependenciesContainerBuilder<*>.addDependencies(
    featuresNavigator: FeatureNavigator
) {
    when (destination) {
        LoginScreenDestination -> dependency(featuresNavigator)
    }
}
