package cat.itb.m78.exercices.Navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object Screen0
    @Serializable
    data object Screen1
    @Serializable
    data object Screen2
    @Serializable
    data class Screen3(val message: String)
}

@Composable
fun LibNavScreenSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Screen0) {
        composable<Destination.Screen0>{
            Screen0(
                navigateToScreen1 = { navController.navigate(Destination.Screen1) },
                navigateToScreen2 = { navController.navigate(Destination.Screen2) },
                navigateToScreen3 = { navController.navigate(Destination.Screen3(it)) }
            )
        }
        composable<Destination.Screen1> {
            Screen1(
                navigateToScreen0 = { navController.navigate(Destination.Screen0) }
            )
        }
        composable<Destination.Screen2> {
            Screen2 (
                navigateToScreen0 = { navController.navigate(Destination.Screen0) }
            )
        }
        composable<Destination.Screen3> { backStack ->
            val message = backStack.toRoute<Destination.Screen3>().message
            Screen3(message){ navController.navigate(Destination.Screen0) }
        }
    }
}
