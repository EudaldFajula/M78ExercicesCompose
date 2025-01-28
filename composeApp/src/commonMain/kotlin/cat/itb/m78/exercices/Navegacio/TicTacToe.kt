package cat.itb.m78.exercices.Navegacio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import kotlin.math.absoluteValue

object DestinationTicTacToe {
    @Serializable
    data object ScreenPlayButton
    @Serializable
    data object ScreenPlayGame
    @Serializable
    data class ScreenFinish(val message: String)
}


@Composable
fun LivNavTicTacToe() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DestinationTicTacToe.ScreenPlayButton) {
        composable<DestinationTicTacToe.ScreenPlayButton>{
            ScreenPlayButton(
                ScreenPlayGame = { navController.navigate(DestinationTicTacToe.ScreenPlayGame) },
            )
        }
        composable<DestinationTicTacToe.ScreenPlayGame> {
            ScreenPlayGame(
                ScreenFinish = { navController.navigate(DestinationTicTacToe.ScreenFinish) }
            )
        }
        composable<DestinationTicTacToe.ScreenFinish> { backStack ->
            val message = backStack.toRoute<DestinationTicTacToe.ScreenFinish>().message
            Screen3(message){ navController.navigate(DestinationTicTacToe.ScreenPlayButton) }
        }
    }
}

@Composable
fun ScreenPlayButton(ScreenPlayGame: () -> Unit){
    Button(onClick = ScreenPlayGame){
        Text("Play Game")
    }
}

@Composable
fun ScreenPlayGame(ScreenFinish: () -> Unit){
    var moves = 0
        Column(){
            Row{
                Button(onClick = ScreenFinish ){}
                Button(onClick = ScreenFinish){}
                Button(onClick = ScreenFinish){}
            }
            Row{
                Button(onClick = ScreenFinish){}
                Button(onClick = ScreenFinish){}
                Button(onClick = ScreenFinish){}
            }
            Row{
                Button(onClick = ScreenFinish){}
                Button(onClick = ScreenFinish){}
                Button(onClick = ScreenFinish){}
            }
        }
}