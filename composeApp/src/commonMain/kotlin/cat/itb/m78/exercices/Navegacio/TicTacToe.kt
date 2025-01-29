package cat.itb.m78.exercices.Navegacio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
    val moves = remember { mutableStateOf(0) }
    val TextButton1 = remember { mutableStateOf("") }
    val TextButton2 = remember { mutableStateOf("") }
    var TextButton3 = remember { mutableStateOf("") }
    var TextButton4 = remember { mutableStateOf("") }
    var TextButton5 = remember { mutableStateOf("") }
    var TextButton6 = remember { mutableStateOf("") }
    var TextButton7 = remember { mutableStateOf("") }
    var TextButton8 = remember { mutableStateOf("") }
    var TextButton9 = remember { mutableStateOf("") }
    var ValidateButton1 = remember { mutableStateOf(true) }
    var ValidateButton2 = remember { mutableStateOf(true) }
    var ValidateButton3 = remember { mutableStateOf(true) }
    var ValidateButton4 = remember { mutableStateOf(true) }
    var ValidateButton5 = remember { mutableStateOf(true) }
    var ValidateButton6 = remember { mutableStateOf(true) }
    var ValidateButton7 = remember { mutableStateOf(true) }
    var ValidateButton8 = remember { mutableStateOf(true) }
    var ValidateButton9 = remember { mutableStateOf(true) }
    Column(){
        Row{
            Button(onClick = {
                if (ValidateButton1.value) {
                    ValidateButton1.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton1.value = "X"
                    } else {
                        TextButton1.value = "O"
                    }
                }
            }){
                Text(TextButton1.value)
            }
            Button(onClick = {
                if (ValidateButton2.value) {
                    ValidateButton2.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton2.value = "X"
                    } else {
                        TextButton2.value = "O"
                    }
                }
            }){
                Text(TextButton2.value)
            }
            Button(onClick = {
                if (ValidateButton3.value) {
                    ValidateButton3.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton3.value = "X"
                    } else {
                        TextButton3.value = "O"
                    }
                }
            }){
                Text(TextButton3.value)
            }
        }
        Row{
            Button(onClick = {
                if (ValidateButton4.value) {
                    ValidateButton4.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton4.value = "X"
                    } else {
                        TextButton4.value = "O"
                    }
                }
            }){
                Text(TextButton4.value)
            }
            Button(onClick = {
                if (ValidateButton5.value) {
                    ValidateButton5.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton5.value = "X"
                    } else {
                        TextButton5.value = "O"
                    }
                }
            }){
                Text(TextButton5.value)
            }
            Button(onClick = {
                if (ValidateButton6.value) {
                    ValidateButton6.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton6.value = "X"
                    } else {
                        TextButton6.value = "O"
                    }
                }
            }){
                Text(TextButton6.value)
            }
        }
        Row{
            Button(onClick = {
                if (ValidateButton7.value) {
                    ValidateButton7.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton7.value = "X"
                    } else {
                        TextButton7.value = "O"
                    }
                }
            }){
                Text(TextButton7.value)
            }
            Button(onClick = {
                if (ValidateButton8.value) {
                    ValidateButton8.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton8.value = "X"
                    } else {
                        TextButton8.value = "O"
                    }
                }
            }){
                Text(TextButton8.value)
            }
            Button(onClick = {
                if (ValidateButton9.value) {
                    ValidateButton9.value = false
                    moves.value++
                    if (moves.value % 2 == 0) {
                        TextButton9.value = "X"
                    } else {
                        TextButton9.value = "O"
                    }
                }
            }){
                Text(TextButton9.value)
            }
        }
    }
}