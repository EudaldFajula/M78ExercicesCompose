package cat.itb.m78.exercices.State

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
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
fun DiceRoller() {
    // NOTA: guarda int
    val dice = 1..6
    var randomDice by remember { mutableStateOf(dice.random()) }
    var randomDice2 by remember { mutableStateOf(dice.random()) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { padding ->
        //Background Image
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(Res.drawable.tapestry),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(Res.drawable.title),
                contentDescription = null,
            )
            Button(onClick = {
                randomDice = dice.random()
                randomDice2 = dice.random()
                if (randomDice == 6 && randomDice2 == 6) {
                    scope.launch {
                        snackbarHostState.showSnackbar("JACKPOT!!")
                    }
                }
            }) {
                Text("Roll the dice")

            }
            Row() {
                ShowDice(randomDice)
                ShowDice(randomDice2)
            }
        }
    }
}

@Composable
fun ShowDice(value: Int) {
    when (value) {
        1 -> Image(painter = painterResource(Res.drawable.dice_1), contentDescription = null)
        2 -> Image(painter = painterResource(Res.drawable.dice_2), contentDescription = null)
        3 -> Image(painter = painterResource(Res.drawable.dice_3), contentDescription = null)
        4 -> Image(painter = painterResource(Res.drawable.dice_4), contentDescription = null)
        5 -> Image(painter = painterResource(Res.drawable.dice_5), contentDescription = null)
        6 -> Image(painter = painterResource(Res.drawable.dice_6), contentDescription = null)
        else -> {
            Image(painter = painterResource(Res.drawable.dice_1), contentDescription = null)
        }
    }

}