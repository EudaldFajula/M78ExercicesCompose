package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.ktor.websocket.Frame

@Composable
fun GoodMorningAndNight(){
    var normalText = remember { mutableStateOf("Good ?!") }
    Column(){
        Text(normalText.value)
        Button(onClick = {
            normalText.value = "Good Morning!"
        }) {
            Text("Morning")
        }
        Button(onClick = {
            normalText.value = "Good Night!"
        }) {
            Text("Night")
        }
    }

}