package cat.itb.m78.exercices.PracticaTrivial

enum class TrivialSubject{Kotlin, Html}
data class TrivialSettings(
    val difficulty : TrivialSubject = TrivialSubject.Kotlin,
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
