package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class ViewModelCounter : ViewModel(){
    val text = mutableStateOf(0)
    var text2 = mutableStateOf(0)
    fun PointsPlus1(){
        text.value++
    }
    fun PointsPlus2(){
        text2.value++
    }
}

@Composable
fun ProgramCounter(){
    val viewModel = viewModel { ViewModelCounter() }
    var points1 = viewModel.text.value
    var points2 = viewModel.text2.value
    Row {
        Column {
            Text(points1.toString())
            Button(onClick = {
                viewModel.PointsPlus1()
            }){Text("Points Team 1")}
        }
        Column{
            Text(points2.toString())
            Button(onClick = {
                viewModel.PointsPlus2()
            }){ Text("Points Team 2")}
        }
    }
}



