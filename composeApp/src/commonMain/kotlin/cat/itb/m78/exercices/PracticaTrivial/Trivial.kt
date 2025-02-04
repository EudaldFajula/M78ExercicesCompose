@file:OptIn(ExperimentalMaterial3Api::class)

package cat.itb.m78.exercices.PracticaTrivial

import androidx.collection.mutableIntSetOf
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.itb.m78.exercices.Navegacio.Screen3
import cat.itb.m78.exercices.Navegacio.ViewModelTicTacToe
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Trivial
import org.jetbrains.compose.resources.painterResource

data class Question(val question: String, val correctAnswer1: String, val answer2: String, val answer3: String, val answer4: String)

val sportQuestion = listOf(
    // Preguntas fáciles
    Question(
        question = "¿Cuántos jugadores tiene un equipo de fútbol en el campo?",
        correctAnswer1 = "11",
        answer2 = "10",
        answer3 = "12",
        answer4 = "9"
    ),
    Question(
        question = "¿Quién es conocido como el 'Rey del Fútbol'?",
        correctAnswer1 = "Pelé",
        answer2 = "Cristiano Ronaldo",
        answer3 = "Lionel Messi",
        answer4 = "Diego Maradona"
    ),
    Question(
        question = "¿En qué deporte se utiliza una raqueta para golpear una pelota?",
        correctAnswer1 = "Tenis",
        answer2 = "Fútbol",
        answer3 = "Baloncesto",
        answer4 = "Béisbol"
    ),
    Question(
        question = "¿En qué país se originó el fútbol?",
        correctAnswer1 = "Inglaterra",
        answer2 = "España",
        answer3 = "Brasil",
        answer4 = "Argentina"
    ),
    Question(
        question = "¿Cómo se llama el estadio de fútbol del FC Barcelona?",
        correctAnswer1 = "Camp Nou",
        answer2 = "Santiago Bernabéu",
        answer3 = "Old Trafford",
        answer4 = "Anfield"
    ),
    Question(
        question = "¿En qué deporte se juega un torneo llamado 'Roland Garros'?",
        correctAnswer1 = "Tenis",
        answer2 = "Fútbol",
        answer3 = "Golf",
        answer4 = "Baloncesto"
    ),
    Question(
        question = "¿Cuántos puntos vale un gol en fútbol?",
        correctAnswer1 = "1",
        answer2 = "3",
        answer3 = "2",
        answer4 = "5"
    ),
    Question(
        question = "¿Qué deporte tiene un torneo llamado 'Super Bowl'?",
        correctAnswer1 = "Fútbol americano",
        answer2 = "Béisbol",
        answer3 = "Fútbol",
        answer4 = "Baloncesto"
    ),
    Question(
        question = "¿En qué deporte se utiliza una batea y una pelota?",
        correctAnswer1 = "Béisbol",
        answer2 = "Fútbol",
        answer3 = "Tenis",
        answer4 = "Hockey"
    ),
    Question(
        question = "¿Cuántos puntos se anotan con un gol en hockey sobre hielo?",
        correctAnswer1 = "1",
        answer2 = "2",
        answer3 = "3",
        answer4 = "4"
    ),
    Question(
        question = "¿Cuántos minutos dura un partido de baloncesto?",
        correctAnswer1 = "48",
        answer2 = "60",
        answer3 = "40",
        answer4 = "30"
    ),
    Question(
        question = "¿Qué país es famoso por sus futbolistas conocidos como los 'Los Guerreros'?",
        correctAnswer1 = "Colombia",
        answer2 = "Argentina",
        answer3 = "Brasil",
        answer4 = "México"
    ),
    Question(
        question = "¿Qué deporte se juega con una pelota esférica y se juega en una cancha rectangular?",
        correctAnswer1 = "Fútbol",
        answer2 = "Béisbol",
        answer3 = "Hockey",
        answer4 = "Baloncesto"
    ),
    Question(
        question = "¿Quién es el máximo goleador histórico de la UEFA Champions League?",
        correctAnswer1 = "Cristiano Ronaldo",
        answer2 = "Lionel Messi",
        answer3 = "Raúl González",
        answer4 = "Robert Lewandowski"
    ),
    Question(
        question = "¿En qué deporte se juega el torneo 'Wimbledon'?",
        correctAnswer1 = "Tenis",
        answer2 = "Fútbol",
        answer3 = "Golf",
        answer4 = "Baloncesto"
    ),

    // Preguntas intermedias
    Question(
        question = "¿En qué país se originó el baloncesto?",
        correctAnswer1 = "Estados Unidos",
        answer2 = "Canadá",
        answer3 = "Francia",
        answer4 = "España"
    ),
    Question(
        question = "¿Cuántos equipos participan en la Copa del Mundo de Fútbol?",
        correctAnswer1 = "32",
        answer2 = "24",
        answer3 = "48",
        answer4 = "16"
    ),
    Question(
        question = "¿Cuál es el nombre de la cancha de baloncesto?",
        correctAnswer1 = "Cancha",
        answer2 = "Pista",
        answer3 = "Campo",
        answer4 = "Tablero"
    ),
    Question(
        question = "¿Quién fue el máximo goleador de la Copa del Mundo de 2018?",
        correctAnswer1 = "Harry Kane",
        answer2 = "Lionel Messi",
        answer3 = "Neymar",
        answer4 = "Kylian Mbappé"
    ),
    Question(
        question = "¿Qué significa la palabra 'offside' en fútbol?",
        correctAnswer1 = "Estar en posición ilegal",
        answer2 = "Una falta dentro del área",
        answer3 = "Un tipo de pase largo",
        answer4 = "Un tipo de tarjeta amarilla"
    ),
    Question(
        question = "¿Qué jugador de tenis ha ganado más títulos de Grand Slam en la historia?",
        correctAnswer1 = "Margaret Court",
        answer2 = "Serena Williams",
        answer3 = "Roger Federer",
        answer4 = "Venus Williams"
    ),
    Question(
        question = "¿Cuántos puntos vale un gol en fútbol?",
        correctAnswer1 = "1",
        answer2 = "3",
        answer3 = "2",
        answer4 = "5"
    ),
    Question(
        question = "¿Qué jugadora ganó el último título del US Open de tenis?",
        correctAnswer1 = "Coco Gauff",
        answer2 = "Serena Williams",
        answer3 = "Venus Williams",
        answer4 = "Simona Halep"
    ),
    Question(
        question = "¿Cuántos jugadores hay en un equipo de rugby?",
        correctAnswer1 = "15",
        answer2 = "11",
        answer3 = "9",
        answer4 = "10"
    ),
    Question(
        question = "¿Qué equipo ganó el último Super Bowl?",
        correctAnswer1 = "Kansas City Chiefs",
        answer2 = "San Francisco 49ers",
        answer3 = "Dallas Cowboys",
        answer4 = "New England Patriots"
    ),

    // Preguntas difíciles
    Question(
        question = "¿En qué año se fundó la NBA?",
        correctAnswer1 = "1946",
        answer2 = "1950",
        answer3 = "1960",
        answer4 = "1980"
    ),
    Question(
        question = "¿Cuántos campeonatos de la Copa del Mundo ha ganado Brasil?",
        correctAnswer1 = "5",
        answer2 = "6",
        answer3 = "4",
        answer4 = "7"
    ),
    Question(
        question = "¿Quién es el máximo goleador histórico de la UEFA Champions League?",
        correctAnswer1 = "Cristiano Ronaldo",
        answer2 = "Lionel Messi",
        answer3 = "Raúl González",
        answer4 = "Robert Lewandowski"
    ),
    Question(
        question = "¿Cuál fue el primer país en ganar una medalla de oro en fútbol olímpico?",
        correctAnswer1 = "Reino Unido",
        answer2 = "Brasil",
        answer3 = "Francia",
        answer4 = "México"
    ),
    Question(
        question = "¿Qué equipo de la NFL tiene más Super Bowls ganados?",
        correctAnswer1 = "New England Patriots",
        answer2 = "Dallas Cowboys",
        answer3 = "Pittsburgh Steelers",
        answer4 = "San Francisco 49ers"
    ),
    Question(
        question = "¿En qué ciudad se celebraron los Juegos Olímpicos de 2008?",
        correctAnswer1 = "Pekín",
        answer2 = "Londres",
        answer3 = "Río de Janeiro",
        answer4 = "Sydney"
    ),
    Question(
        question = "¿Qué atleta tiene el récord mundial de los 100 metros planos?",
        correctAnswer1 = "Usain Bolt",
        answer2 = "Tyson Gay",
        answer3 = "Justin Gatlin",
        answer4 = "Asafa Powell"
    ),
    Question(
        question = "¿En qué deporte se realiza el famoso 'slam dunk'?",
        correctAnswer1 = "Baloncesto",
        answer2 = "Fútbol",
        answer3 = "Rugby",
        answer4 = "Tenis"
    ),
    Question(
        question = "¿Quién tiene el récord de más victorias en el Tour de Francia?",
        correctAnswer1 = "Eddy Merckx",
        answer2 = "Lance Armstrong",
        answer3 = "Miguel Indurain",
        answer4 = "Chris Froome"
    ),
    Question(
        question = "¿En qué país se celebró la Copa del Mundo de Fútbol en 2014?",
        correctAnswer1 = "Brasil",
        answer2 = "Alemania",
        answer3 = "Francia",
        answer4 = "Sudáfrica"
    )
)

val mathsQuestions = listOf(
    // Preguntas fáciles
    Question(
        question = "¿Cuánto es 2 + 2?",
        correctAnswer1 = "4",
        answer2 = "5",
        answer3 = "3",
        answer4 = "6"
    ),
    Question(
        question = "¿Cuánto es 3 x 3?",
        correctAnswer1 = "9",
        answer2 = "8",
        answer3 = "7",
        answer4 = "6"
    ),
    Question(
        question = "¿Cuánto es 10 - 3?",
        correctAnswer1 = "7",
        answer2 = "6",
        answer3 = "5",
        answer4 = "4"
    ),
    Question(
        question = "¿Cuánto es 5 + 3?",
        correctAnswer1 = "8",
        answer2 = "7",
        answer3 = "6",
        answer4 = "9"
    ),
    Question(
        question = "¿Cuánto es 6 x 2?",
        correctAnswer1 = "12",
        answer2 = "10",
        answer3 = "11",
        answer4 = "13"
    ),
    Question(
        question = "¿Cuánto es 12 / 4?",
        correctAnswer1 = "3",
        answer2 = "4",
        answer3 = "5",
        answer4 = "2"
    ),
    Question(
        question = "¿Cuánto es 20 - 10?",
        correctAnswer1 = "10",
        answer2 = "5",
        answer3 = "15",
        answer4 = "12"
    ),
    Question(
        question = "¿Cuánto es 7 x 1?",
        correctAnswer1 = "7",
        answer2 = "6",
        answer3 = "8",
        answer4 = "9"
    ),
    Question(
        question = "¿Cuánto es 15 / 3?",
        correctAnswer1 = "5",
        answer2 = "6",
        answer3 = "4",
        answer4 = "3"
    ),
    Question(
        question = "¿Cuánto es 25 - 5?",
        correctAnswer1 = "20",
        answer2 = "15",
        answer3 = "25",
        answer4 = "30"
    ),
    Question(
        question = "¿Cuánto es 100 / 10?",
        correctAnswer1 = "10",
        answer2 = "20",
        answer3 = "15",
        answer4 = "5"
    ),
    Question(
        question = "¿Cuánto es 8 + 2?",
        correctAnswer1 = "10",
        answer2 = "8",
        answer3 = "9",
        answer4 = "12"
    ),
    Question(
        question = "¿Cuánto es 18 - 9?",
        correctAnswer1 = "9",
        answer2 = "8",
        answer3 = "7",
        answer4 = "6"
    ),
    Question(
        question = "¿Cuánto es 4 x 5?",
        correctAnswer1 = "20",
        answer2 = "25",
        answer3 = "15",
        answer4 = "10"
    ),
    Question(
        question = "¿Cuánto es 6 + 7?",
        correctAnswer1 = "13",
        answer2 = "14",
        answer3 = "12",
        answer4 = "11"
    ),

    // Preguntas intermedias
    Question(
        question = "¿Cuánto es 8 x 7?",
        correctAnswer1 = "56",
        answer2 = "48",
        answer3 = "64",
        answer4 = "50"
    ),
    Question(
        question = "¿Cuánto es 15 x 12?",
        correctAnswer1 = "180",
        answer2 = "150",
        answer3 = "120",
        answer4 = "200"
    ),
    Question(
        question = "¿Cuánto es 45 / 5?",
        correctAnswer1 = "9",
        answer2 = "8",
        answer3 = "7",
        answer4 = "6"
    ),
    Question(
        question = "¿Cuánto es 25 x 4?",
        correctAnswer1 = "100",
        answer2 = "120",
        answer3 = "80",
        answer4 = "90"
    ),
    Question(
        question = "¿Cuánto es 144 / 12?",
        correctAnswer1 = "12",
        answer2 = "15",
        answer3 = "10",
        answer4 = "14"
    ),
    Question(
        question = "¿Cuál es el resultado de 6^2?",
        correctAnswer1 = "36",
        answer2 = "18",
        answer3 = "24",
        answer4 = "42"
    ),
    Question(
        question = "¿Cuánto es 3 x (4 + 2)?",
        correctAnswer1 = "18",
        answer2 = "12",
        answer3 = "20",
        answer4 = "15"
    ),
    Question(
        question = "¿Cuánto es 15% de 200?",
        correctAnswer1 = "30",
        answer2 = "25",
        answer3 = "20",
        answer4 = "15"
    ),
    Question(
        question = "¿Cuánto es 9^2?",
        correctAnswer1 = "81",
        answer2 = "72",
        answer3 = "63",
        answer4 = "91"
    ),
    Question(
        question = "¿Cuál es el valor de pi (π) aproximado?",
        correctAnswer1 = "3.14",
        answer2 = "3.41",
        answer3 = "3.45",
        answer4 = "3.10"
    ),
    Question(
        question = "¿Cuánto es 20% de 50?",
        correctAnswer1 = "10",
        answer2 = "15",
        answer3 = "12",
        answer4 = "20"
    ),
    Question(
        question = "¿Cuánto es 11 x 11?",
        correctAnswer1 = "121",
        answer2 = "110",
        answer3 = "130",
        answer4 = "140"
    ),
    Question(
        question = "¿Cuánto es 8 x (6 + 3)?",
        correctAnswer1 = "72",
        answer2 = "60",
        answer3 = "56",
        answer4 = "80"
    ),
    Question(
        question = "¿Cuánto es 36 / 9?",
        correctAnswer1 = "4",
        answer2 = "3",
        answer3 = "5",
        answer4 = "6"
    ),

    // Preguntas difíciles
    Question(
        question = "¿Cuánto es 15^3?",
        correctAnswer1 = "3375",
        answer2 = "3250",
        answer3 = "3500",
        answer4 = "3300"
    ),
    Question(
        question = "¿Cuánto es la raíz cuadrada de 144?",
        correctAnswer1 = "12",
        answer2 = "14",
        answer3 = "16",
        answer4 = "10"
    ),
    Question(
        question = "¿Cuánto es 9 x 9 x 9?",
        correctAnswer1 = "729",
        answer2 = "700",
        answer3 = "710",
        answer4 = "740"
    ),
    Question(
        question = "¿Cuál es el área de un círculo con radio 7?",
        correctAnswer1 = "153.94",
        answer2 = "140.75",
        answer3 = "145.67",
        answer4 = "160.85"
    ),
    Question(
        question = "¿Cuánto es 7! (7 factorial)?",
        correctAnswer1 = "5040",
        answer2 = "3000",
        answer3 = "4500",
        answer4 = "6000"
    ),
    Question(
        question = "¿Qué es el valor de x en la ecuación 2x + 5 = 11?",
        correctAnswer1 = "3",
        answer2 = "2",
        answer3 = "4",
        answer4 = "5"
    ),
    Question(
        question = "¿Cuánto es 2^10?",
        correctAnswer1 = "1024",
        answer2 = "1000",
        answer3 = "1100",
        answer4 = "1010"
    ),
    Question(
        question = "¿Cuál es el valor de log(100)?",
        correctAnswer1 = "2",
        answer2 = "3",
        answer3 = "1",
        answer4 = "4"
    ),
    Question(
        question = "¿Cuál es la derivada de f(x) = x^2?",
        correctAnswer1 = "2x",
        answer2 = "x",
        answer3 = "x^3",
        answer4 = "x^2"
    ),
    Question(
        question = "¿Qué es la integral de 1/x?",
        correctAnswer1 = "ln|x|",
        answer2 = "x^2",
        answer3 = "e^x",
        answer4 = "x"
    ),
    Question(
        question = "¿Cuánto es 2 + 3 × (7 - 4)?",
        correctAnswer1 = "11",
        answer2 = "10",
        answer3 = "12",
        answer4 = "9"
    ),
    Question(
        question = "¿Cuál es el área de un triángulo con base 8 y altura 5?",
        correctAnswer1 = "20",
        answer2 = "25",
        answer3 = "30",
        answer4 = "35"
    ),
    Question(
        question = "¿Cuánto es 45 x 45?",
        correctAnswer1 = "2025",
        answer2 = "2150",
        answer3 = "2100",
        answer4 = "2200"
    ),
    Question(
        question = "¿Cuál es la suma de los ángulos interiores de un triángulo?",
        correctAnswer1 = "180°",
        answer2 = "360°",
        answer3 = "90°",
        answer4 = "270°"
    )
)

val musicQuestions = listOf(
    // Preguntas fáciles
    Question(
        question = "¿Quién es conocido como el 'Rey del Pop'?",
        correctAnswer1 = "Michael Jackson",
        answer2 = "Elvis Presley",
        answer3 = "Freddie Mercury",
        answer4 = "Justin Timberlake"
    ),
    Question(
        question = "¿Qué instrumento musical tiene 88 teclas?",
        correctAnswer1 = "Piano",
        answer2 = "Guitarra",
        answer3 = "Violín",
        answer4 = "Bajo"
    ),
    Question(
        question = "¿Quién cantó la canción 'Like a Virgin'?",
        correctAnswer1 = "Madonna",
        answer2 = "Lady Gaga",
        answer3 = "Beyoncé",
        answer4 = "Ariana Grande"
    ),
    Question(
        question = "¿De qué banda es miembro Paul McCartney?",
        correctAnswer1 = "The Beatles",
        answer2 = "Queen",
        answer3 = "Pink Floyd",
        answer4 = "Rolling Stones"
    ),
    Question(
        question = "¿Qué instrumento toca Jimi Hendrix?",
        correctAnswer1 = "Guitarra eléctrica",
        answer2 = "Bajo",
        answer3 = "Batería",
        answer4 = "Teclado"
    ),
    Question(
        question = "¿Qué género musical es famoso en Cuba?",
        correctAnswer1 = "Salsa",
        answer2 = "Reggaeton",
        answer3 = "Pop",
        answer4 = "Rock"
    ),
    Question(
        question = "¿Qué banda británica escribió la canción 'Bohemian Rhapsody'?",
        correctAnswer1 = "Queen",
        answer2 = "The Rolling Stones",
        answer3 = "The Beatles",
        answer4 = "Led Zeppelin"
    ),
    Question(
        question = "¿Qué cantante es conocido como la 'Reina del Soul'?",
        correctAnswer1 = "Aretha Franklin",
        answer2 = "Whitney Houston",
        answer3 = "Beyoncé",
        answer4 = "Mariah Carey"
    ),
    Question(
        question = "¿En qué país nació el tango?",
        correctAnswer1 = "Argentina",
        answer2 = "Brasil",
        answer3 = "España",
        answer4 = "México"
    ),
    Question(
        question = "¿Quién es el autor de la famosa obra 'La Flauta Mágica'?",
        correctAnswer1 = "Wolfgang Amadeus Mozart",
        answer2 = "Ludwig van Beethoven",
        answer3 = "Johann Sebastian Bach",
        answer4 = "Frédéric Chopin"
    ),
    Question(
        question = "¿Qué cantante famoso tiene el apodo de 'La Diva del Bronx'?",
        correctAnswer1 = "Jennifer Lopez",
        answer2 = "Shakira",
        answer3 = "Rihanna",
        answer4 = "Selena Gomez"
    ),
    Question(
        question = "¿En qué año murió Elvis Presley?",
        correctAnswer1 = "1977",
        answer2 = "1980",
        answer3 = "1968",
        answer4 = "1995"
    ),
    Question(
        question = "¿Cómo se llama la banda de rock que lanzó el álbum 'Dark Side of the Moon'?",
        correctAnswer1 = "Pink Floyd",
        answer2 = "The Rolling Stones",
        answer3 = "Led Zeppelin",
        answer4 = "AC/DC"
    ),
    Question(
        question = "¿Qué cantante popularizó la canción 'Billie Jean'?",
        correctAnswer1 = "Michael Jackson",
        answer2 = "Prince",
        answer3 = "Stevie Wonder",
        answer4 = "Elvis Presley"
    ),
    Question(
        question = "¿Qué instrumento se utiliza en la música clásica para crear una melodía grave?",
        correctAnswer1 = "Contrabajo",
        answer2 = "Violín",
        answer3 = "Flauta",
        answer4 = "Trombón"
    ),

    // Preguntas intermedias
    Question(
        question = "¿Quién es el autor de la obra 'Sinfonía No. 9'?",
        correctAnswer1 = "Ludwig van Beethoven",
        answer2 = "Johann Sebastian Bach",
        answer3 = "Wolfgang Amadeus Mozart",
        answer4 = "Frédéric Chopin"
    ),
    Question(
        question = "¿Cuál de estos géneros musicales tiene sus raíces en Nueva Orleans?",
        correctAnswer1 = "Jazz",
        answer2 = "Salsa",
        answer3 = "Reggaetón",
        answer4 = "Rock"
    ),
    Question(
        question = "¿Qué banda de rock es conocida por su álbum 'Abbey Road'?",
        correctAnswer1 = "The Beatles",
        answer2 = "The Rolling Stones",
        answer3 = "Queen",
        answer4 = "Pink Floyd"
    ),
    Question(
        question = "¿En qué género musical se destaca la cantante Billie Eilish?",
        correctAnswer1 = "Pop alternativo",
        answer2 = "Rock",
        answer3 = "Reggaetón",
        answer4 = "Salsa"
    ),
    Question(
        question = "¿Cómo se llama el disco debut de Beyoncé como solista?",
        correctAnswer1 = "Dangerously in Love",
        answer2 = "Lemonade",
        answer3 = "B'Day",
        answer4 = "4"
    ),
    Question(
        question = "¿Quién es conocido como el 'Rey del Reggaetón'?",
        correctAnswer1 = "Daddy Yankee",
        answer2 = "Don Omar",
        answer3 = "J Balvin",
        answer4 = "Ozuna"
    ),
    Question(
        question = "¿Qué instrumento tiene cuerdas y se toca con un arco?",
        correctAnswer1 = "Violín",
        answer2 = "Guitarra",
        answer3 = "Piano",
        answer4 = "Saxofón"
    ),
    Question(
        question = "¿En qué década se lanzó el álbum 'Thriller' de Michael Jackson?",
        correctAnswer1 = "1980s",
        answer2 = "1990s",
        answer3 = "1970s",
        answer4 = "2000s"
    ),
    Question(
        question = "¿Qué cantante tiene el álbum más vendido de todos los tiempos?",
        correctAnswer1 = "Michael Jackson",
        answer2 = "Elvis Presley",
        answer3 = "The Beatles",
        answer4 = "Whitney Houston"
    ),
    Question(
        question = "¿De qué país proviene el grupo musical ABBA?",
        correctAnswer1 = "Suecia",
        answer2 = "Noruega",
        answer3 = "Finlandia",
        answer4 = "Dinamarca"
    ),
    Question(
        question = "¿Quién es el autor de la famosa obra 'Una noche en el monte Calvo'?",
        correctAnswer1 = "Modest Mussorgsky",
        answer2 = "P. Tchaikovsky",
        answer3 = "Claude Debussy",
        answer4 = "Igor Stravinsky"
    ),
    Question(
        question = "¿En qué ciudad nació la famosa banda de rock Queen?",
        correctAnswer1 = "Londres",
        answer2 = "Los Angeles",
        answer3 = "Liverpool",
        answer4 = "Nueva York"
    ),
    Question(
        question = "¿Qué cantante fue conocida como la 'Diva de los 80s'?",
        correctAnswer1 = "Whitney Houston",
        answer2 = "Madonna",
        answer3 = "Celine Dion",
        answer4 = "Aretha Franklin"
    ),
    Question(
        question = "¿Qué instrumento musical tiene 6 cuerdas?",
        correctAnswer1 = "Guitarra",
        answer2 = "Piano",
        answer3 = "Violín",
        answer4 = "Bajo"
    ),

    // Preguntas difíciles
    Question(
        question = "¿Quién compuso la famosa ópera 'Carmen'?",
        correctAnswer1 = "Georges Bizet",
        answer2 = "Wolfgang Amadeus Mozart",
        answer3 = "Giuseppe Verdi",
        answer4 = "Ludwig van Beethoven"
    ),
    Question(
        question = "¿En qué año se fundó la banda Pink Floyd?",
        correctAnswer1 = "1965",
        answer2 = "1970",
        answer3 = "1960",
        answer4 = "1980"
    ),
    Question(
        question = "¿Cómo se llama el famoso álbum de Radiohead lanzado en 1997?",
        correctAnswer1 = "OK Computer",
        answer2 = "The Bends",
        answer3 = "Kid A",
        answer4 = "Amnesiac"
    ),
    Question(
        question = "¿Qué compositor de música clásica fue conocido como 'el compositor de la luz'?",
        correctAnswer1 = "Claude Debussy",
        answer2 = "Johann Sebastian Bach",
        answer3 = "Ludwig van Beethoven",
        answer4 = "Frédéric Chopin"
    ),
    Question(
        question = "¿Qué artista fue el líder de la banda The Velvet Underground?",
        correctAnswer1 = "Lou Reed",
        answer2 = "David Bowie",
        answer3 = "Jim Morrison",
        answer4 = "Iggy Pop"
    ),
    Question(
        question = "¿Qué banda lanzó el famoso álbum 'The Dark Side of the Moon'?",
        correctAnswer1 = "Pink Floyd",
        answer2 = "Led Zeppelin",
        answer3 = "The Rolling Stones",
        answer4 = "Queen"
    ),
    Question(
        question = "¿Quién fue el productor detrás del álbum 'Thriller' de Michael Jackson?",
        correctAnswer1 = "Quincy Jones",
        answer2 = "George Martin",
        answer3 = "Phil Spector",
        answer4 = "Max Martin"
    ),
    Question(
        question = "¿Cómo se llama el primer álbum de Bob Dylan?",
        correctAnswer1 = "Bob Dylan",
        answer2 = "The Freewheelin' Bob Dylan",
        answer3 = "Highway 61 Revisited",
        answer4 = "Blonde on Blonde"
    ),
    Question(
        question = "¿En qué ciudad nació el famoso compositor Johann Sebastian Bach?",
        correctAnswer1 = "Eisenach",
        answer2 = "Berlín",
        answer3 = "Londres",
        answer4 = "Viena"
    ),
    Question(
        question = "¿Cuál es el nombre real de la cantante conocida como Lady Gaga?",
        correctAnswer1 = "Stefani Joanne Angelina Germanotta",
        answer2 = "Ariana Grande",
        answer3 = "Catherine Elizabeth Hudson",
        answer4 = "Rihanna Fenty"
    ),
    Question(
        question = "¿Qué famoso compositor fue conocido por su estilo de música impresionista?",
        correctAnswer1 = "Claude Debussy",
        answer2 = "Ludwig van Beethoven",
        answer3 = "Wolfgang Amadeus Mozart",
        answer4 = "Frédéric Chopin"
    ),
    Question(
        question = "¿Quién fue el guitarrista principal de Led Zeppelin?",
        correctAnswer1 = "Jimmy Page",
        answer2 = "Eric Clapton",
        answer3 = "Jimi Hendrix",
        answer4 = "Keith Richards"
    ),
    Question(
        question = "¿Qué banda lanzó el álbum 'The Joshua Tree'?",
        correctAnswer1 = "U2",
        answer2 = "The Rolling Stones",
        answer3 = "Queen",
        answer4 = "The Beatles"
    ),
    Question(
        question = "¿Qué compositor de música clásica fue conocido como 'el compositor de las sombras'?",
        correctAnswer1 = "Frédéric Chopin",
        answer2 = "Ludwig van Beethoven",
        answer3 = "Johann Sebastian Bach",
        answer4 = "Wolfgang Amadeus Mozart"
    )
)

val randomQuestion = listOf(
    "Sport",
    "Maths",
    "Music"
)

object TrivialScreen {
    @Serializable
    data object MenuScreen
    @Serializable
    data object SettingsScreen
    @Serializable
    data object GameScreen
    @Serializable
    data class EndScreen(val message: String)
}

class viewModelTrivial : ViewModel(){
    val score = mutableStateOf(0)
    val difficulty = mutableStateOf("Easy")
    val timeLeft =  mutableStateOf(60)
    fun timeMinus(){
        timeLeft.value--
    }
}

@Composable
fun BasicCountdownTimer() {
    val viewModel = viewModel { viewModelTrivial() }
    LaunchedEffect(key1 = viewModel.timeLeft.value) {
        while (viewModel.timeLeft.value > 0) {
            delay(1000L)
            viewModel.timeMinus()
        }
    }
    Text(text = viewModel.timeLeft.value.toString())
}

@Composable
fun NavLivTrivial(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TrivialScreen.MenuScreen){
        composable<TrivialScreen.MenuScreen>{
            MenuScreen(
                navigateToSettingsScreen = { navController.navigate(TrivialScreen.SettingsScreen) },
                navigateToGameScreen = { navController.navigate(TrivialScreen.GameScreen) }
            )
        }
        composable<TrivialScreen.SettingsScreen>{
            SettingsScreen(
                navigateToMenuScreen = { navController.navigate(TrivialScreen.MenuScreen) }
            )
        }
        composable<TrivialScreen.GameScreen>{
            GameScreen(
                navigateToEndScreen = {navController.navigate(TrivialScreen.EndScreen)}
            )
        }
        composable<TrivialScreen.EndScreen> { backStack ->
            val message = backStack.toRoute<TrivialScreen.EndScreen>().message
            Screen3(message){ navController.navigate(TrivialScreen.EndScreen) }
        }
    }
}

@Composable
fun MenuScreen(navigateToGameScreen: () -> Unit, navigateToSettingsScreen: () -> Unit){
    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(Res.drawable.Trivial), contentDescription = null)
        Button(onClick = navigateToGameScreen){
            Text("New Game")
        }
        Button(onClick = navigateToSettingsScreen){
            Text("Settings")
        }
    }
}

@Composable
fun SettingsScreen(navigateToMenuScreen: () -> Unit){
    Column() {
        Row() {
            Text("Difficulty")

        }
    }
}

@Composable
fun GameScreen(navigateToEndScreen: () -> Unit){
    val viewModel = viewModel { viewModelTrivial() }
    var maxValue = 0
    var minValue = 0
    var questionText = ""
    if (viewModel.difficulty.value == "Easy"){
        maxValue = 15
    }else if(viewModel.difficulty.value == "Normal"){
        minValue = 15
        maxValue = 30
    }else{
        minValue = 30
        maxValue = 45
    }
    if(randomQuestion.random() == "Maths"){
        questionText = mathsQuestions.random().question
    }
    Column() {
        Text()
    }
}


