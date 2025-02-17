package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.util.valuesOf
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun CountDownScreen(timeLeft:Int, timeMinus: () -> Unit, resetTime: () -> Unit,changeQuestion:()->Unit,nextRound:() ->Unit, totalRounds: Int,navigateToEndScreen: (Int) -> Unit, score: Int){
    val maxRounds = TrivialSettingsManager.get().questionsPerGame
    LaunchedEffect(timeLeft){
        delay(1.seconds)
        timeMinus()
    }
    if(timeLeft == 0){
        resetTime()
        changeQuestion()
        nextRound()
        if (totalRounds == maxRounds){
            navigateToEndScreen(score)
        }
    }
    Column{
        Text("Time Left: " + timeLeft.toString())
    }
}

@Composable
fun GameScreen(navigateToEndScreen: (Int) -> Unit){
    val viewModel = viewModel {  ViewModelTrivial() }
    GameScreenViewModel(navigateToEndScreen, viewModel::changeQuestion, viewModel::nextRound, viewModel.totalRounds.value, viewModel::timeMinus, viewModel.timeLeft.value,viewModel.score.value, viewModel::correctAnswer, viewModel.questionText.value,viewModel::resetTime)
}

@Composable
fun GameScreenViewModel(navigateToEndScreen: (Int) -> Unit, changeQuestion:()->Unit, nextRound:() ->Unit, totalRounds: Int, timeMinus: () -> Unit, timeLeft: Int, score: Int, correctAnswer:()->Unit, questionText: Question, resetTime:()->Unit){
    var usage = remember { mutableStateOf(false) }
    val maxRounds = TrivialSettingsManager.get().questionsPerGame
    if (!usage.value){
        changeQuestion()
        usage.value = true
    }
    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp).background(Color.LightGray),horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text(totalRounds.toString() + " / " + maxRounds.toString())
        }
        Column(modifier = Modifier.padding(top = 20.dp).background(Color.LightGray),horizontalAlignment = Alignment.CenterHorizontally){
            CountDownScreen(timeLeft, timeMinus,resetTime,changeQuestion,nextRound,totalRounds,navigateToEndScreen,score)
            Text(questionText.question)
        }
        Row(){
            Button(onClick = {nextRound(); correctAnswer(); changeQuestion(); resetTime()
                if (totalRounds == maxRounds){
                    navigateToEndScreen(score)
                }}){
                Text(questionText.correctAnswer)
            }
            Button(onClick = {nextRound(); changeQuestion(); resetTime()
                if (totalRounds == maxRounds){
                    navigateToEndScreen(score)
                }}){
                Text(questionText.answer2)
            }
        }
        Row(){
            Button(onClick = {nextRound(); changeQuestion(); resetTime()
                if (totalRounds == maxRounds){
                    navigateToEndScreen(score)
                }}) {
                Text(questionText.answer3)
            }
            Button(onClick = {nextRound(); changeQuestion(); resetTime()
                if (totalRounds== maxRounds){
                    navigateToEndScreen(score)
                }}) {
                Text(questionText.answer4)
            }
        }
    }
}