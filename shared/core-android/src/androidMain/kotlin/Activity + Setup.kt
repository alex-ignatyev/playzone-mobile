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

//TODO Добавить боттом нав и тулбалы как в репе
//TODO уЛчше разобраться в настройке боттом бара
//TODO Вынести профиль в модуль
//TODO Добавить экранов на главный граф
//TODO добавить тулбар как в репе
//TODO Добавить логаут как в репе по протухшему токену
//TODO боттом шиты
//TODO Добавить диалоги
//TODO Почитать еще про либу нава
//TODO Поднять котлин до 1/8 и внести все правки

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
    val startRoute = if (!isAuthorised) AuthNavGraph else MainNavGraph

    ApplicationScaffold(
        startRoute = startRoute,
        navController = navController,
        bottomBar = { BottomNavBar(navController) }
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
