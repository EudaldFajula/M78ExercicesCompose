package cat.itb.m78.exercices.State

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.allFontResources
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.dice_2
import m78exercices.composeapp.generated.resources.dice_3
import m78exercices.composeapp.generated.resources.dice_4
import m78exercices.composeapp.generated.resources.dice_5
import m78exercices.composeapp.generated.resources.dice_6
import m78exercices.composeapp.generated.resources.diceroller
import m78exercices.composeapp.generated.resources.generatedFace
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiceRoller(){
    val dice = listOf(
        Res.drawable.dice_1,
        Res.drawable.dice_2,
        Res.drawable.dice_3,
        Res.drawable.dice_4,
        Res.drawable.dice_5,
        Res.drawable.dice_6
    )
    var randomDice = remember { mutableStateOf(dice.random()) }
    var randomDice2 = remember { mutableStateOf(dice.random()) }
    var roll by remember { mutableStateOf(false) }
    var jackpotText = remember { mutableStateOf("") }
    //Background Image
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(Res.drawable.tapestry),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {
        Image(
            painter = painterResource(Res.drawable.title),
            contentDescription = null,
        )
        Button(onClick = {
            roll = true

        } ){
            Text("Roll the dice")
        }
        Row(){
            if (roll){
                randomDice.value = dice.random()
                randomDice2.value =  dice.random()
                if (randomDice.value == Res.drawable.dice_6 && randomDice2.value == Res.drawable.dice_6){
                    jackpotText.value = "JACKPOT!"
                }else {
                    jackpotText.value = ""
                }
                roll = false
            }
            Image(painter = painterResource(randomDice.value), contentDescription = null)
            Image(painter = painterResource(randomDice2.value), contentDescription = null)
        }
        Text(jackpotText.value)
    }

}