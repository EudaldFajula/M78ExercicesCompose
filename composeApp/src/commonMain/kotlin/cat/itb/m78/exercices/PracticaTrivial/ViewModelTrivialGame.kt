package cat.itb.m78.exercices.PracticaTrivial

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
data class Question(var question: String, val correctAnswer: String, val answer2: String, val answer3: String, val answer4: String)

//Sport questions
object SportEasyQuestions {
    //Easy Questions
    val question1 = Question("¿Cuántos jugadores tiene un equipo de fútbol en el campo?","11","10","12","9")
    val question2 = Question("¿Quién es conocido como el 'Rey del Fútbol'?","Pelé","Cristiano Ronaldo","Lionel Messi","Diego Maradona")
    val question3 = Question("¿En qué deporte se utiliza una raqueta para golpear una pelota?","Tenis","Fútbol","Baloncesto","Béisbol")
    val question4 = Question("¿En qué país se originó el fútbol?","Inglaterra","España","Brasil","Argentina")
    val question5 = Question("¿Cómo se llama el estadio de fútbol del FC Barcelona?", "Camp Nou", "Santiago Bernabéu", "Old Trafford", "Anfield")
    val question6 = Question("¿En qué deporte se juega un torneo llamado 'Roland Garros'?", "Tenis", "Fútbol", "Golf", "Baloncesto")
    val question7 = Question("¿Cuántos puntos vale un gol en fútbol?", "1", "3", "2", "5")
    val question8 = Question("¿Qué deporte tiene un torneo llamado 'Super Bowl'?", "Fútbol americano", "Béisbol", "Fútbol", "Balonces")
    val question9 = Question("¿En qué deporte se utiliza una batea y una pelota?", "Béisbol", "Fútbol", "Tenis", "Hockey")
    val question10 = Question("¿Cuántos puntos se anotan con un gol en hockey sobre hielo?", "1", "2", "3", "4")
    val question11 = Question("¿Cuántos minutos dura un partido de baloncesto?", "48", "60", "40", "30")
    val question12 = Question("¿Qué país es famoso por sus futbolistas conocidos como los 'Los Guerreros'?", "Colombia", "Argentina", "Brasil", "México")
    val question13 = Question("¿Qué deporte se juega con una pelota esférica y se juega en una cancha rectangular?", "Fútbol", "Béisbol", "Hockey", "Baloncesto")
    val question14 = Question("¿Quién es el máximo goleador histórico de la UEFA Champions League?", "Cristiano Ronaldo", "Lionel Messi", "Raúl González", "Robert Lewandowski")
    val question15 = Question("¿En qué deporte se juega el torneo 'Wimbledon'?", "Tenis", "Fútbol", "Golf", "Baloncesto")
}
object SportIntermediateQuestions{
    //Intermediate Questions
    val question1 = Question("¿En qué país se originó el baloncesto?", "Estados Unidos", "Canadá", "Francia", "España")
    val question2 = Question("¿Cuántos equipos participan en la Copa del Mundo de Fútbol?", "32", "24", "48", "16")
    val question3 = Question("¿Cuál es el nombre de la cancha de baloncesto?", "Cancha", "Pista", "Campo", "Tablero")
    val question4 = Question("¿Quién fue el máximo goleador de la Copa del Mundo de 2018?", "Harry Kane", "Lionel Messi", "Neymar", "Kylian Mbappé")
    val question5 = Question("¿Qué significa la palabra 'offside' en fútbol?", "Estar en posición ilegal", "Una falta dentro del área", "Un tipo de pase largo", "Un tipo de tarjeta amarilla")
    val question6 = Question("¿Qué jugador de tenis ha ganado más títulos de Grand Slam en la historia?", "Margaret Court", "Serena Williams", "Roger Federer", "Venus Williams")
    val question7 = Question("¿Cuántos puntos vale un gol en fútbol?", "1", "3", "2", "5")
    val question8 = Question("¿Qué jugadora ganó el último título del US Open de tenis?", "Coco Gauff", "Serena Williams", "Venus Williams", "Simona Halep")
    val question9 = Question("¿Cuántos jugadores hay en un equipo de rugby?", "15", "11", "9", "10")
    val question10 = Question("¿Qué equipo ganó el último Super Bowl?", "Kansas City Chiefs", "San Francisco 49ers", "Dallas Cowboys", "New England Patriots")
    val question11 = Question("¿En qué país se originó el rugby?"," Inglaterra","Australia","Nueva Zelanda","Sudáfrica")
    val question12 = Question(" ¿Cuántos jugadores hay en un equipo de baloncesto en la cancha durante un partido oficial?","5","7","9","6")
    val question13 = Question("¿Cuál es el equipo con más títulos de la UEFA Champions League?","Real Madrid","Manchester United","Barcelona","Bayern Múnich")
    val question14 = Question("¿En qué deporte se usa un \"puck\"?","Hockey sobre hielo","Cricket","Béisbol","Fútbol")
    val question15 = Question("¿Quién ganó el Mundial de Fútbol de 2010?","España","Brasil","Argentina","Alemania")
}
object SportDifficultQuestions{
    //Difficult Questions
    val question1 = Question("¿En qué año se fundó la NBA?", "1946", "1950", "1960", "1980")
    val question2 = Question("¿Cuántos campeonatos de la Copa del Mundo ha ganado Brasil?", "5", "6", "4", "7")
    val question3 = Question("¿Quién es el máximo goleador histórico de la UEFA Champions League?", "Cristiano Ronaldo", "Lionel Messi", "Raúl González", "Robert Lewandowski")
    val question4 = Question("¿Cuál fue el primer país en ganar una medalla de oro en fútbol olímpico?", "Reino Unido", "Brasil", "Francia", "México")
    val question5 = Question("¿Qué equipo de la NFL tiene más Super Bowls ganados?", "New England Patriots", "Dallas Cowboys", "Pittsburgh Steelers", "San Francisco 49ers")
    val question6 = Question("¿En qué ciudad se celebraron los Juegos Olímpicos de 2008?", "Pekín", "Londres", "Río de Janeiro", "Sydney")
    val question7 = Question("¿Qué atleta tiene el récord mundial de los 100 metros planos?", "Usain Bolt", "Tyson Gay", "Justin Gatlin", "Asafa Powell")
    val question8 = Question("¿En qué deporte se realiza el famoso 'slam dunk'?", "Baloncesto", "Fútbol", "Rugby", "Tenis")
    val question9 = Question("¿Quién tiene el récord de más victorias en el Tour de Francia?", "Eddy Merckx", "Lance Armstrong", "Miguel Indurain", "Chris Froome")
    val question10 = Question("¿En qué país se celebró la Copa del Mundo de Fútbol en 2014?", "Brasil", "Alemania", "Francia", "Sudáfrica")
    val question11 = Question("¿Quién es el único jugador en la historia del fútbol en haber ganado la Copa del Mundo como jugador y como entrenador?","Franz Beckenbauer","Zinedine Zidane","Michel Platini","Carlos Alberto Parreira")
    val question12 = Question("¿Cuál es el récord de velocidad más rápido alcanzado en la historia del ciclismo en carretera?","182.3 km/h","160.7 km/h","130.9 km/h","122.5 km/h")
    val question13 = Question("¿Quién fue el primer jugador en la historia de la NBA en superar los 100 puntos en un solo partido?","Wilt Chamberlain","Kareem Abdul-Jabbar","Michael Jordan","Kobe Bryant")
    val question14 = Question("¿En qué año se celebró la primera edición de los Juegos Olímpicos de Invierno?","1924","1936","1932","1920")
    val question15 = Question("¿Cuál fue la primera selección nacional en ganar la Copa América en la era profesional?","Uruguay","Brasil","Argentina","Chile")
}
//Math questions
object MathEasyQuestions {
    // Easy Questions
    val question1 = Question("¿Cuánto es 2 + 2?", "4", "5", "3", "6")
    val question2 = Question("¿Cuánto es 3 x 3?", "9", "8", "7", "6")
    val question3 = Question("¿Cuánto es 10 - 3?", "7", "6", "5", "4")
    val question4 = Question("¿Cuánto es 5 + 3?", "8", "7", "6", "9")
    val question5 = Question("¿Cuánto es 6 x 2?", "12", "10", "11", "13")
    val question6 = Question("¿Cuánto es 12 / 4?", "3", "4", "5", "2")
    val question7 = Question("¿Cuánto es 20 - 10?", "10", "5", "15", "12")
    val question8 = Question("¿Cuánto es 7 x 1?", "7", "6", "8", "9")
    val question9 = Question("¿Cuánto es 15 / 3?", "5", "6", "4", "3")
    val question10 = Question("¿Cuánto es 25 - 5?", "20", "15", "25", "30")
    val question11 = Question("¿Cuánto es 100 / 10?", "10", "20", "15", "5")
    val question12 = Question("¿Cuánto es 8 + 2?", "10", "8", "9", "12")
    val question13 = Question("¿Cuánto es 18 - 9?", "9", "8", "7", "6")
    val question14 = Question("¿Cuánto es 4 x 5?", "20", "25", "15", "10")
    val question15 = Question("¿Cuánto es 6 + 7?", "13", "14", "12", "11")
}
object MathIntermediateQuestions {
    // Intermediate Questions
    val question1 = Question("¿Cuánto es 8 x 7?", "56", "48", "64", "50")
    val question2 = Question("¿Cuánto es 15 x 12?", "180", "150", "120", "200")
    val question3 = Question("¿Cuánto es 45 / 5?", "9", "8", "7", "6")
    val question4 = Question("¿Cuánto es 25 x 4?", "100", "120", "80", "90")
    val question5 = Question("¿Cuánto es 144 / 12?", "12", "15", "10", "14")
    val question6 = Question("¿Cuál es el resultado de 6^2?", "36", "18", "24", "42")
    val question7 = Question("¿Cuánto es 3 x (4 + 2)?", "18", "12", "20", "15")
    val question8 = Question("¿Cuánto es 15% de 200?", "30", "25", "20", "15")
    val question9 = Question("¿Cuánto es 9^2?", "81", "72", "63", "91")
    val question10 = Question("¿Cuál es el valor de pi (π) aproximado?", "3.14", "3.41", "3.45", "3.10")
    val question11 = Question("¿Cuánto es 20% de 50?", "10", "15", "12", "20")
    val question12 = Question("¿Cuánto es 11 x 11?", "121", "110", "130", "140")
    val question13 = Question("¿Cuánto es 8 x (6 + 3)?", "72", "60", "56", "80")
    val question14 = Question("¿Cuánto es 36 / 9?", "4", "3", "5", "6")
    val question15 = Question("¿Cuánto es 36 ÷ 6?","6","5","7","8")
}
object MathDifficultQuestions {
    // Difficult Questions
    val question1 = Question("¿Cuánto es 15^3?", "3375", "3250", "3500", "3300")
    val question2 = Question("¿Cuánto es la raíz cuadrada de 144?", "12", "14", "16", "10")
    val question3 = Question("¿Cuánto es 9 x 9 x 9?", "729", "700", "710", "740")
    val question4 = Question("¿Cuál es el área de un círculo con radio 7?", "153.94", "140.75", "145.67", "160.85")
    val question5 = Question("¿Cuánto es 7! (7 factorial)?", "5040", "3000", "4500", "6000")
    val question6 = Question("¿Qué es el valor de x en la ecuación 2x + 5 = 11?", "3", "2", "4", "5")
    val question7 = Question("¿Cuánto es 2^10?", "1024", "1000", "1100", "1010")
    val question8 = Question("¿Cuál es el valor de log(100)?", "2", "3", "1", "4")
    val question9 = Question("¿Cuál es la derivada de f(x) = x^2?", "2x", "x", "x^3", "x^2")
    val question10 = Question("¿Qué es la integral de 1/x?", "ln|x|", "x^2", "e^x", "x")
    val question11 = Question("¿Cuánto es 2 + 3 × (7 - 4)?", "11", "10", "12", "9")
    val question12 = Question("¿Cuál es el área de un triángulo con base 8 y altura 5?", "20", "25", "30", "35")
    val question13 = Question("¿Cuánto es 45 x 45?", "2025", "2150", "2100", "2200")
    val question14 = Question("¿Cuál es la suma de los ángulos interiores de un triángulo?", "180°", "360°", "90°", "270°")
    val question15 = Question("¿Cuál es el valor de la integral ∫(2x^3 - 4x^2 + 6x) dx?","½x^4 - 4x^3 + 3x^2 + C","x^4 - 4x^2 + 6x + C","x^4 - 4x^3 + 6x^2 + C","2x^4 - 4x^3 + 3x^2 + C")
}
//Muisc questions
object MusicEasyQuestions{
    //Easy Questions
    val question1 = Question("¿Quién es conocido como el 'Rey del Pop'?", "Michael Jackson", "Elvis Presley", "Freddie Mercury", "Justin Timberlake")
    val question2 = Question("¿Qué instrumento musical tiene 88 teclas?", "Piano", "Guitarra", "Violín", "Bajo")
    val question3 = Question("¿Quién cantó la canción 'Like a Virgin'?", "Madonna", "Lady Gaga", "Beyoncé", "Ariana Grande")
    val question4 = Question("¿De qué banda es miembro Paul McCartney?", "The Beatles", "Queen", "Pink Floyd", "Rolling Stones")
    val question5 = Question("¿Qué instrumento toca Jimi Hendrix?", "Guitarra eléctrica", "Bajo", "Batería", "Teclado")
    val question6 = Question("¿Qué género musical es famoso en Cuba?", "Salsa", "Reggaeton", "Pop", "Rock")
    val question7 = Question("¿Qué banda británica escribió la canción 'Bohemian Rhapsody'?", "Queen", "The Rolling Stones", "The Beatles", "Led Zeppelin")
    val question8 = Question("¿Qué cantante es conocido como la 'Reina del Soul'?", "Aretha Franklin", "Whitney Houston", "Beyoncé", "Mariah Carey")
    val question9 = Question("¿En qué país nació el tango?", "Argentina", "Brasil", "España", "México")
    val question10 = Question("¿Quién es el autor de la famosa obra 'La Flauta Mágica'?", "Wolfgang Amadeus Mozart", "Ludwig van Beethoven", "Johann Sebastian Bach", "Frédéric Chopin")
    val question11 = Question("¿Qué cantante famoso tiene el apodo de 'La Diva del Bronx'?", "Jennifer Lopez", "Shakira", "Rihanna", "Selena Gomez")
    val question12 = Question("¿En qué año murió Elvis Presley?", "1977", "1980", "1968", "1995")
    val question13 = Question("¿Cómo se llama la banda de rock que lanzó el álbum 'Dark Side of the Moon'?", "Pink Floyd", "The Rolling Stones", "Led Zeppelin", "AC/DC")
    val question14 = Question("¿Qué cantante popularizó la canción 'Billie Jean'?", "Michael Jackson", "Prince", "Stevie Wonder", "Elvis Presley")
    val question15 = Question("¿Qué instrumento se utiliza en la música clásica para crear una melodía grave?", "Contrabajo", "Violín", "Flauta", "Trombón")
}
object MusicIntermediateQuestions{
    //Intermediate Questions
    val question1 = Question("¿Quién es el autor de la obra 'Sinfonía No. 9'?", "Ludwig van Beethoven", "Johann Sebastian Bach", "Wolfgang Amadeus Mozart", "Frédéric Chopin")
    val question2 = Question("¿Cuál de estos géneros musicales tiene sus raíces en Nueva Orleans?", "Jazz", "Salsa", "Reggaetón", "Rock")
    val question3 = Question("¿Qué banda de rock es conocida por su álbum 'Abbey Road'?", "The Beatles", "The Rolling Stones", "Queen", "Pink Floyd")
    val question4 = Question("¿En qué género musical se destaca la cantante Billie Eilish?", "Pop alternativo", "Rock", "Reggaetón", "Salsa")
    val question5 = Question("¿Cómo se llama el disco debut de Beyoncé como solista?", "Dangerously in Love", "Lemonade", "B'Day", "4")
    val question6 = Question("¿Quién es conocido como el 'Rey del Reggaetón'?", "Daddy Yankee", "Don Omar", "J Balvin", "Ozuna")
    val question7 = Question("¿Qué instrumento tiene cuerdas y se toca con un arco?", "Violín", "Guitarra", "Piano", "Saxofón")
    val question8 = Question("¿En qué década se lanzó el álbum 'Thriller' de Michael Jackson?", "1980s", "1990s", "1970s", "2000s")
    val question9 = Question("¿Qué cantante tiene el álbum más vendido de todos los tiempos?", "Michael Jackson", "Elvis Presley", "The Beatles", "Whitney Houston")
    val question10 = Question("¿De qué país proviene el grupo musical ABBA?", "Suecia", "Noruega", "Finlandia", "Dinamarca")
    val question11 = Question("¿Quién es el autor de la famosa obra 'Una noche en el monte Calvo'?", "Modest Mussorgsky", "P. Tchaikovsky", "Claude Debussy", "Igor Stravinsky")
    val question12 = Question("¿En qué ciudad nació la famosa banda de rock Queen?", "Londres", "Los Angeles", "Liverpool", "Nueva York")
    val question13 = Question("¿Qué cantante fue conocida como la 'Diva de los 80s'?", "Whitney Houston", "Madonna", "Celine Dion", "Aretha Franklin")
    val question14 = Question("¿Qué instrumento musical tiene 6 cuerdas?", "Guitarra", "Piano", "Violín", "Bajo")
    val question15 = Question("¿Quién fue el líder de la banda de rock Queen?","Freddie Mercury","Brian May","Roger Taylor","John Deacon")
}
object MusicDifficultQuestions{
    // Difficult Questions
    val question1 = Question("¿Quién compuso la famosa ópera 'Carmen'?", "Georges Bizet", "Wolfgang Amadeus Mozart", "Giuseppe Verdi", "Ludwig van Beethoven")
    val question2 = Question("¿En qué año se fundó la banda Pink Floyd?", "1965", "1970", "1960", "1980")
    val question3 = Question("¿Cómo se llama el famoso álbum de Radiohead lanzado en 1997?", "OK Computer", "The Bends", "Kid A", "Amnesiac")
    val question4 = Question("¿Qué compositor de música clásica fue conocido como 'el compositor de la luz'?", "Claude Debussy", "Johann Sebastian Bach", "Ludwig van Beethoven", "Frédéric Chopin")
    val question5 = Question("¿Qué artista fue el líder de la banda The Velvet Underground?", "Lou Reed", "David Bowie", "Jim Morrison", "Iggy Pop")
    val question6 = Question("¿Qué banda lanzó el famoso álbum 'The Dark Side of the Moon'?", "Pink Floyd", "Led Zeppelin", "The Rolling Stones", "Queen")
    val question7 = Question("¿Quién fue el productor detrás del álbum 'Thriller' de Michael Jackson?", "Quincy Jones", "George Martin", "Phil Spector", "Max Martin")
    val question8 = Question("¿Cómo se llama el primer álbum de Bob Dylan?", "Bob Dylan", "The Freewheelin' Bob Dylan", "Highway 61 Revisited", "Blonde on Blonde")
    val question9 = Question("¿En qué ciudad nació el famoso compositor Johann Sebastian Bach?", "Eisenach", "Berlín", "Londres", "Viena")
    val question10 = Question("¿Cuál es el nombre real de la cantante conocida como Lady Gaga?", "Stefani Joanne Angelina Germanotta", "Ariana Grande", "Catherine Elizabeth Hudson", "Rihanna Fenty")
    val question11 = Question("¿Qué famoso compositor fue conocido por su estilo de música impresionista?", "Claude Debussy", "Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Frédéric Chopin")
    val question12 = Question("¿Quién fue el guitarrista principal de Led Zeppelin?", "Jimmy Page", "Eric Clapton", "Jimi Hendrix", "Keith Richards")
    val question13 = Question("¿Qué banda lanzó el álbum 'The Joshua Tree'?", "U2", "The Rolling Stones", "Queen", "The Beatles")
    val question14 = Question("¿Qué compositor de música clásica fue conocido como 'el compositor de las sombras'?", "Frédéric Chopin", "Ludwig van Beethoven", "Johann Sebastian Bach", "Wolfgang Amadeus Mozart")
    val question15 = Question("¿Quién compuso la famosa ópera \"La Traviata\"?","Giuseppe Verdi","Richard Wagner","Wolfgang Amadeus Mozart","Giacomo Puccini")
}

class ViewModelTrivial : ViewModel(){
    val settings = TrivialSettingsManager.get()
    val score = mutableStateOf(0)
    val totalRounds = mutableStateOf(0)
    val timeLeft =  mutableStateOf(10)
    val questionText = mutableStateOf<Question>(Question("","","","",""))

    fun timeMinus(){
        timeLeft.value--
    }
    fun resetTime(){
        timeLeft.value = 10
    }
    fun correctAnswer(){
        score.value++
    }
    fun nextRound(){
        totalRounds.value++
    }
    fun changeQuestion(){
        when (settings.difficulty){
            Difficulty.EASY -> when (settings.subject){
                TypeQuestions.MATH -> questionText.value = mathEasyQuestionsList.random()
                TypeQuestions.SPORT -> questionText.value = sportsEasyQuestionsList.random()
                TypeQuestions.MUSIC -> questionText.value = musicEasyQuestionsList.random()
            }
            Difficulty.MEDIUM -> when (settings.subject){
                TypeQuestions.MATH -> questionText.value = mathIntermediateQuestionsList.random()
                TypeQuestions.SPORT -> questionText.value = sportsIntermediateQuestionsList.random()
                TypeQuestions.MUSIC -> questionText.value = musicIntermediateQuestionsList.random()
            }
            Difficulty.DIFFICULT -> when (settings.subject){
                TypeQuestions.MATH -> questionText.value = mathDifficultQuestionsList.random()
                TypeQuestions.SPORT -> questionText.value = sportsDifficultQuestionsList.random()
                TypeQuestions.MUSIC -> questionText.value = musicDifficultQuestionsList.random()
            }
        }
    }
    private val mathEasyQuestionsList = listOf(
        MathEasyQuestions.question1,
        MathEasyQuestions.question2,
        MathEasyQuestions.question3,
        MathEasyQuestions.question4,
        MathEasyQuestions.question5,
        MathEasyQuestions.question6,
        MathEasyQuestions.question7,
        MathEasyQuestions.question8,
        MathEasyQuestions.question9,
        MathEasyQuestions.question10,
        MathEasyQuestions.question11,
        MathEasyQuestions.question12,
        MathEasyQuestions.question13,
        MathEasyQuestions.question14,
        MathEasyQuestions.question15
    )
    private val mathIntermediateQuestionsList = listOf(
        MathIntermediateQuestions.question1,
        MathIntermediateQuestions.question2,
        MathIntermediateQuestions.question3,
        MathIntermediateQuestions.question4,
        MathIntermediateQuestions.question5,
        MathIntermediateQuestions.question6,
        MathIntermediateQuestions.question7,
        MathIntermediateQuestions.question8,
        MathIntermediateQuestions.question9,
        MathIntermediateQuestions.question10,
        MathIntermediateQuestions.question11,
        MathIntermediateQuestions.question12,
        MathIntermediateQuestions.question13,
        MathIntermediateQuestions.question14,
        MathIntermediateQuestions.question15,
    )
    private val mathDifficultQuestionsList = listOf(
        MathDifficultQuestions.question1,
        MathDifficultQuestions.question2,
        MathDifficultQuestions.question3,
        MathDifficultQuestions.question4,
        MathDifficultQuestions.question5,
        MathDifficultQuestions.question6,
        MathDifficultQuestions.question7,
        MathDifficultQuestions.question8,
        MathDifficultQuestions.question9,
        MathDifficultQuestions.question10,
        MathDifficultQuestions.question11,
        MathDifficultQuestions.question12,
        MathDifficultQuestions.question13,
        MathDifficultQuestions.question14,
        MathDifficultQuestions.question15,
    )
    private val sportsEasyQuestionsList = listOf(
        SportEasyQuestions.question1,
        SportEasyQuestions.question2,
        SportEasyQuestions.question3,
        SportEasyQuestions.question4,
        SportEasyQuestions.question5,
        SportEasyQuestions.question6,
        SportEasyQuestions.question7,
        SportEasyQuestions.question8,
        SportEasyQuestions.question9,
        SportEasyQuestions.question10,
        SportEasyQuestions.question11,
        SportEasyQuestions.question12,
        SportEasyQuestions.question13,
        SportEasyQuestions.question14,
        SportEasyQuestions.question15,
    )
    private val sportsIntermediateQuestionsList = listOf(
        SportIntermediateQuestions.question1,
        SportIntermediateQuestions.question2,
        SportIntermediateQuestions.question3,
        SportIntermediateQuestions.question4,
        SportIntermediateQuestions.question5,
        SportIntermediateQuestions.question6,
        SportIntermediateQuestions.question7,
        SportIntermediateQuestions.question8,
        SportIntermediateQuestions.question9,
        SportIntermediateQuestions.question10,
        SportIntermediateQuestions.question11,
        SportIntermediateQuestions.question12,
        SportIntermediateQuestions.question13,
        SportIntermediateQuestions.question14,
        SportIntermediateQuestions.question15,
    )
    private val sportsDifficultQuestionsList = listOf(
        SportDifficultQuestions.question1,
        SportDifficultQuestions.question2,
        SportDifficultQuestions.question3,
        SportDifficultQuestions.question4,
        SportDifficultQuestions.question5,
        SportDifficultQuestions.question6,
        SportDifficultQuestions.question7,
        SportDifficultQuestions.question8,
        SportDifficultQuestions.question9,
        SportDifficultQuestions.question10,
        SportDifficultQuestions.question11,
        SportDifficultQuestions.question12,
        SportDifficultQuestions.question13,
        SportDifficultQuestions.question14,
        SportDifficultQuestions.question15,
    )
    private val musicEasyQuestionsList = listOf(
        MusicEasyQuestions.question1,
        MusicEasyQuestions.question2,
        MusicEasyQuestions.question3,
        MusicEasyQuestions.question4,
        MusicEasyQuestions.question5,
        MusicEasyQuestions.question6,
        MusicEasyQuestions.question7,
        MusicEasyQuestions.question8,
        MusicEasyQuestions.question9,
        MusicEasyQuestions.question10,
        MusicEasyQuestions.question11,
        MusicEasyQuestions.question12,
        MusicEasyQuestions.question13,
        MusicEasyQuestions.question14,
        MusicEasyQuestions.question15,
    )
    private val musicIntermediateQuestionsList = listOf(
        MusicIntermediateQuestions.question1,
        MusicIntermediateQuestions.question2,
        MusicIntermediateQuestions.question3,
        MusicIntermediateQuestions.question4,
        MusicIntermediateQuestions.question5,
        MusicIntermediateQuestions.question6,
        MusicIntermediateQuestions.question7,
        MusicIntermediateQuestions.question8,
        MusicIntermediateQuestions.question9,
        MusicIntermediateQuestions.question10,
        MusicIntermediateQuestions.question11,
        MusicIntermediateQuestions.question12,
        MusicIntermediateQuestions.question13,
        MusicIntermediateQuestions.question14,
        MusicIntermediateQuestions.question15,
    )
    private val musicDifficultQuestionsList = listOf(
        MusicDifficultQuestions.question1,
        MusicDifficultQuestions.question2,
        MusicDifficultQuestions.question3,
        MusicDifficultQuestions.question4,
        MusicDifficultQuestions.question5,
        MusicDifficultQuestions.question6,
        MusicDifficultQuestions.question7,
        MusicDifficultQuestions.question8,
        MusicDifficultQuestions.question9,
        MusicDifficultQuestions.question10,
        MusicDifficultQuestions.question11,
        MusicDifficultQuestions.question12,
        MusicDifficultQuestions.question13,
        MusicDifficultQuestions.question14,
        MusicDifficultQuestions.question15,
    )
}