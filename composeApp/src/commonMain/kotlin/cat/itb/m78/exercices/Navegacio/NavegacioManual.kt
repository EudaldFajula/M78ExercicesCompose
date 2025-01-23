package cat.itb.m78.exercices.Navegacio

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.websocket.Frame

sealed interface Screen {
    data object Screen0 : Screen
    data object Screen1 : Screen
    data object Screen2 : Screen
    data class Screen3(val message: String) : Screen
}

private class ManualNavAppViewModel : ViewModel() {
    val currentScreen = mutableStateOf<Screen>(Screen.Screen0)
    fun navigateTo(screen: Screen) {
        currentScreen.value = screen
    }
}

@Composable
fun ManualNav() {
    val viewModel = viewModel { ManualNavAppViewModel() }
    val currentScreen = viewModel.currentScreen.value
    when (currentScreen) {
        Screen.Screen0 -> Screen1(
            navigateToScreen2 = {viewModel.navigateTo(Screen.Screen1)}
        )
        Screen.Screen1 -> Screen1(
            navigateToScreen2 = { viewModel.navigateTo(Screen.Screen2) }
        )
        is Screen.Screen2 -> Screen2(
            navigateToScreen3 = { viewModel.navigateTo(Screen.Screen3(it)) }
        )
        is Screen.Screen3 -> Screen3(currentScreen.message)
    }
}

@Composable
fun Screen0(navigateToScreen0: ()-> Unit){
    Column {
        Button(){
            Text("Screen 1")
        }
        Button(){
            Text("Screen 2")
        }
        Button(){
            Text("Screen 3 - Hello")
        }
        Button(){
            Text("Screen 3 - Bye")
        }
    }
}

@Composable
fun Screen1(navigateToScreen2: ()-> Unit){
    Button(onClick = navigateToScreen2){
        Frame.Text("Go To screen2")
    }
}

@Composable
fun Screen2(navigateToScreen3: (String)-> Unit){
    var text by remember{ mutableStateOf("") }
    TextField(text, onValueChange = {text = it})
    Button(onClick = {navigateToScreen3(text)}){
        Text("Go to Screen 3")
    }
}

@Composable
fun Screen3(message: String){
    Text(message)
}