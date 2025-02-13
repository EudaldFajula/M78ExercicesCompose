

package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable


object TrivialScreen {
    @Serializable
    data object MenuScreen
    @Serializable
    data object SettingsScreen
    @Serializable
    data object GameScreen
    @Serializable
    data class EndScreen(val score: Int)
}

@Composable
fun NavLivTrivial(){
    val navController = rememberNavController()
     NavHost(navController = navController, startDestination = TrivialScreen.MenuScreen){
        composable<TrivialScreen.MenuScreen>{
            MenuScreen(
                navigateToSettingsScreen = { navController.navigate(TrivialScreen.SettingsScreen) },
                navigateToGameScreen = { navController.navigate(TrivialScreen.GameScreen) },
            )
        }
        composable<TrivialScreen.SettingsScreen>{
            SettingsScreen(
                navigateToMenuScreen = {navController.navigate(TrivialScreen.MenuScreen)}
            )
        }
        composable<TrivialScreen.GameScreen>{
            GameScreen(
                navigateToEndScreen = {navController.navigate(TrivialScreen.EndScreen(it))}
            )
        }
        composable<TrivialScreen.EndScreen> {
                backstack ->
            val score: Int = backstack.toRoute<TrivialScreen.EndScreen>().score
            EndScreen(
                score,
                navigateToGameScreen = {navController.navigate(TrivialScreen.MenuScreen)}
            )
        }
    }
}





