package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

enum class Difficulty{
    EASY, MEDIUM, DIFFICULT
}
enum class TypeQuestions{
    SPORT,MUSIC,MATH
}
data class TrivialSettings(
    val difficulty : Difficulty = Difficulty.EASY,
    val subject: TypeQuestions = TypeQuestions.MATH,
    val questionsPerGame: Int = 10
)
/**
 * Stores current setting in Memory.
 * TODO: update to store in disk/DB
 *
 * Usage TrivialSettingsManager.get()
 */
data object TrivialSettingsManager{
    private var settings = TrivialSettings()
    fun update(newSettings: TrivialSettings){
        settings = newSettings
    }
    fun get() = settings
}

@Composable
fun SettingsScreen(navigateToMenuScreen: () -> Unit) {
    val viewModel = viewModel { ViewModelTrivialSettings() }
    SettingsScreenViewModel(viewModel.maxRounds.value, viewModel::changeMaxRounds,viewModel.difficulty.value,viewModel::changeDifficulty, viewModel.typeQuestion.value, viewModel::changeSubjectQuestions, viewModel::saveSettings, navigateToMenuScreen)
}

@Composable
fun SettingsScreenViewModel(rounds: Int, onRoundsChanged: (Int)-> Unit, difficulty: Difficulty, onDifficultyChanged: (Difficulty)->Unit, subject: TypeQuestions, onSubjectChanged: (TypeQuestions) -> Unit, onSave: ()-> Unit, navigateToMenuScreen : ()->Unit){
    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp).background(Color.LightGray),horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Text("Numero Rondas:")
            RadioButtonSingleSelectionMaxRounds(rounds, onRoundsChanged)
        }
        Row(){
            Text("Categoria:")
            RadioButtonSingleSelectionSubject(subject, onSubjectChanged)
        }
        Row(){
            Text("Dificultad")
            RadioButtonSingleSelectionDifficulty(difficulty, onDifficultyChanged)
        }
         Button(onClick = {onSave(); navigateToMenuScreen()}){
            Text("Volver Menu") }
    }
}

class ViewModelTrivialSettings : ViewModel(){
    val difficulty = mutableStateOf(TrivialSettingsManager.get().difficulty)
    val typeQuestion = mutableStateOf(TrivialSettingsManager.get().subject)
    val maxRounds = mutableStateOf(TrivialSettingsManager.get().questionsPerGame)
    fun changeDifficulty(newDifficulty: Difficulty){
        difficulty.value = newDifficulty
    }
    fun changeMaxRounds(newMaxRounds: Int){
        maxRounds.value = newMaxRounds
    }
    fun changeSubjectQuestions(newSubject: TypeQuestions){
        typeQuestion.value = newSubject
    }
    fun saveSettings(){
        val settingsFromInputs = TrivialSettings(difficulty.value, typeQuestion.value, maxRounds.value)
        TrivialSettingsManager.update(settingsFromInputs)
    }
}

@Composable
fun RadioButtonSingleSelectionMaxRounds(value: Int, onValueChanged: (Int)-> Unit, modifier: Modifier = Modifier) {
    val radioOptions = listOf(5, 10, 15)
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == value),
                        onClick = { onValueChanged(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == value),
                    onClick = {onValueChanged(text)}
                )
                Text(
                    text = text.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
@Composable
fun RadioButtonSingleSelectionSubject(value: TypeQuestions, onValueChanged: (TypeQuestions)-> Unit, modifier: Modifier = Modifier) {
    val radioOptions = listOf(TypeQuestions.MATH, TypeQuestions.MUSIC, TypeQuestions.SPORT)
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == value),
                        onClick = { onValueChanged(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == value),
                    onClick = {onValueChanged(value)}
                )
                Text(
                    text = text.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
@Composable
fun RadioButtonSingleSelectionDifficulty(value: Difficulty, onValueChanged: (Difficulty)-> Unit, modifier: Modifier = Modifier) {
    val radioOptions = listOf(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.DIFFICULT)
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == value),
                        onClick = { onValueChanged(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == value),
                    onClick = {onValueChanged(value)}
                )
                Text(
                    text = text.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
