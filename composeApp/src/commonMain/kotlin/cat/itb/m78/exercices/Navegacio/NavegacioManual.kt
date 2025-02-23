package cat.itb.m78.exercices.Navegacio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.websocket.Frame
import kotlinx.serialization.json.JsonNull.content

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
fun NavegacioManual() {
    val viewModel = viewModel { ManualNavAppViewModel() }
    val currentScreen = viewModel.currentScreen.value
    when (currentScreen) {
        Screen.Screen0 -> Screen0(
            navigateToScreen1 = {viewModel.navigateTo(Screen.Screen1)},
            navigateToScreen2 = {viewModel.navigateTo(Screen.Screen2)},
            navigateToScreen3 = {viewModel.navigateTo(Screen.Screen3(it))}
        )
        is Screen.Screen1 -> Screen1 (
            navigateToScreen0 = {viewModel.navigateTo(Screen.Screen0)}
        )
        is Screen.Screen2 -> Screen2 (
            navigateToScreen0 = {viewModel.navigateTo(Screen.Screen0)}
        )
        is Screen.Screen3 -> Screen3 (
            currentScreen.message,
            navigateToScreen0 = {viewModel.navigateTo(Screen.Screen0)}
        )
    }
}

@Composable
fun Screen0(navigateToScreen1: () -> Unit, navigateToScreen2: () -> Unit,navigateToScreen3: (String) -> Unit){
    Column {
        Button(onClick = navigateToScreen1){
            Text("Screen 1")
        }
        Button(onClick = navigateToScreen2){
            Text("Screen 2")
        }
        Button(onClick = {navigateToScreen3("Hello")}){
            Text("Screen 3 - Hello")
        }
        Button(onClick = {navigateToScreen3("Bye")}){
            Text("Screen 3 - Bye")
        }
    }
}

@Composable
fun Screen1(navigateToScreen0: ()-> Unit){
    Column(modifier = Modifier.background(color = Color.Green) .fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End){
        Text("Screen 1")
        Button(onClick = navigateToScreen0){
            Text("Main Menu")
        }
    }

}

@Composable
fun Screen2(navigateToScreen0: ()-> Unit){
    Column(modifier = Modifier.background(color = Color.Red) .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("Screen 2")
        Button(onClick = navigateToScreen0){
            Text("Main Menu")
        }
    }
}

@Composable
fun Screen3(message: String, navigateToScreen0: ()-> Unit){
    Column(modifier = Modifier.background(color = Color.Blue) .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Text("Screen 2")
        Text(message)
        Button(onClick = navigateToScreen0){
            Text("Main Menu")
        }
    }
}