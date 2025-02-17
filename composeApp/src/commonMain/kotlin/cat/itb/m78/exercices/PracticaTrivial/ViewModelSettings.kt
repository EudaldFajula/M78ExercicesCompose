package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelTrivialSettings : ViewModel(){
    val difficulty = mutableStateOf(TrivialSettingsManager.get().difficulty)
    val typeQuestion = mutableStateOf(TrivialSettingsManager.get().subject)
    val maxRounds = mutableStateOf(TrivialSettingsManager.get().questionsPerGame)
    val maxTime = mutableStateOf(TrivialSettingsManager.get().time)
    fun changeDifficulty(newDifficulty: Difficulty){
        difficulty.value = newDifficulty
    }
    fun changeMaxRounds(newMaxRounds: Int){
        maxRounds.value = newMaxRounds
    }
    fun changeSubjectQuestions(newSubject: TypeQuestions){
        typeQuestion.value = newSubject
    }
    fun changeMaxTime(newTime: Int){
        maxTime.value = newTime
    }
    fun saveSettings(){
        val settingsFromInputs = TrivialSettings(difficulty.value, typeQuestion.value, maxRounds.value, maxTime.value)
        TrivialSettingsManager.update(settingsFromInputs)
    }
}