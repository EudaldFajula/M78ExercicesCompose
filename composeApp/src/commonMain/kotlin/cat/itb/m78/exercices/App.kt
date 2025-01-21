package cat.itb.m78.exercices


import HelloWorld
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cat.itb.m78.exercices.State.DiceRoller
import cat.itb.m78.exercices.State.GoodMorningAndNight
import cat.itb.m78.exercices.State.SayHello
import cat.itb.m78.exercices.State.SecretNumberMethod
import cat.itb.m78.exercices.Stateless.Contact
import cat.itb.m78.exercices.Stateless.ContactMethod
import cat.itb.m78.exercices.Stateless.MessagesList
import cat.itb.m78.exercices.Stateless.Resource
import cat.itb.m78.exercices.Stateless.Welcome
import cat.itb.m78.exercices.ViewModel.ProgramCounter
import cat.itb.m78.exercices.ViewModel.ShoppingList
import cat.itb.m78.exercices.theme.AppTheme
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Composable
internal fun App() = AppTheme {
    ShoppingList()
}
