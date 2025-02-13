package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EndScreen(score: Int, navigateToGameScreen: () -> Unit){
    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp).background(Color.LightGray),horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Puntuacion: ")
        Text(score.toString() + " / " + TrivialSettingsManager.get().questionsPerGame.toString())
        Button(onClick = navigateToGameScreen){
            Text("Adiooos")
        }
    }
}