package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em

@Composable
fun SecretNumberMethod(){
    var text by remember { mutableStateOf("") }
    var secretNum = remember { (1..100).random()}
    var textHints = remember{ mutableStateOf(" ")}
    var showHint by remember { mutableStateOf(false) }
    var tries = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,){
        Text("Endevina el número secret")
        TextField(text,
            label = { Text("") },
            onValueChange = {
                text = it
            })
        Button(onClick = {
            showHint = true
            tries.value++
        } ){
            Text("Validar")
        }
        Text("Intents: " + tries.value)
        Text(textHints.value)
        if (showHint){
            if (text.toInt() == secretNum){
                textHints.value = "Has encertat!"
                showHint = false
            }else if (text.toInt() < secretNum){
                textHints.value = "El número que busques és més gran"
                showHint = false
            }else{
                textHints.value = "El número que busques és més petit"
                showHint = false
            }
        }

    }
}