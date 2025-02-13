package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Trivial
import org.jetbrains.compose.resources.painterResource

@Composable
fun MenuScreen(navigateToGameScreen: () -> Unit, navigateToSettingsScreen: () -> Unit){
    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp).background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(Res.drawable.Trivial), contentDescription = null, modifier = Modifier.size(400.dp))
        Button(onClick = navigateToGameScreen){
            Text("New Game")
        }
        Button(onClick = navigateToSettingsScreen){
            Text("Settings")
        }
    }
}