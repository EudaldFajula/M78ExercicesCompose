package cat.itb.m78.exercices.Navegacio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object DestinationTicTacToe {
    @Serializable
    data object ScreenPlayButton
    @Serializable
    data object ScreenPlayGame
    @Serializable
    data class ScreenFinish(val message: String)
}

class ViewModelTicTacToe : ViewModel(){
    var board = mutableStateOf(List(3){List<Boolean?>(3){null}})
    var moves = true
    fun changePlayer() {
        moves = !moves
    }
    fun playAt(x: Int, y: Int){
        if (board.value[x][y] == null){
            val newBoard = board.value.toMutableMatrix()
            newBoard[x][y] = moves
            changePlayer()
            board.value = newBoard
        }
    }
    fun List<List<Boolean?>>.toMutableMatrix(): List<MutableList<Boolean?>> {
        return map { it.toMutableList() }
    }
}

fun showText(boolean: Boolean?) : String{
    if(boolean == true){
        return "X"
    }else if(boolean == false){
        return "O"
    }else{
        return "-"
    }
}

@Composable
fun TicTacToeApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DestinationTicTacToe.ScreenPlayButton) {
        composable<DestinationTicTacToe.ScreenPlayButton>{
            ScreenPlayButton(
                ScreenPlayGame = { navController.navigate(DestinationTicTacToe.ScreenPlayGame) },
            )
        }
        composable<DestinationTicTacToe.ScreenPlayGame> {
            ScreenPlayGame(
                screenFinish = { navController.navigate(DestinationTicTacToe.ScreenFinish) }
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
fun ScreenPlayGame(screenFinish: () -> Unit){
    Column(){
        Row{
            CreateButton(0,0)
            CreateButton(0,1)
            CreateButton(0,2)
        }
        Row{
            CreateButton(1,0)
            CreateButton(1,1)
            CreateButton(1,2)
        }
        Row{
            CreateButton(2,0)
            CreateButton(2,1)
            CreateButton(2,2)
        }
    }
    ComprobateWinner(screenFinish)
}
@Composable
fun CreateButton(x: Int,y: Int){
    val viewModel = viewModel { ViewModelTicTacToe() }
    val board = viewModel.board.value
    Button(onClick = {viewModel.playAt(x, y)}){
        Text(showText(board[x][y]))
    }
}

@Composable
fun ComprobateWinner(screenFinish: () -> Unit){
    val viewModel = viewModel { ViewModelTicTacToe() }
    val board = viewModel.board.value
    if(board[0][0] == true && board[0][1] == true && board[0][2] == true){
        screenFinish()
    }else if (board[1][0] == true && board[1][1] == true && board[1][2] == true){
        screenFinish()
    }else if (board[2][0] == true && board[2][1] == true && board[2][2] == true){
        screenFinish()
    }else if(board[0][0] == false && board[0][1] == false && board[0][2] == false){
        screenFinish()
    }else if (board[1][0] == false && board[1][1] == false && board[1][2] == false){
        screenFinish()
    }else if (board[2][0] == false && board[2][1] == false && board[2][2] == false){
        screenFinish()
    }
}