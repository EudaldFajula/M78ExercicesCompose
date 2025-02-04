package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.Navegacio.TicTacToeApp
import cat.itb.m78.exercices.PracticaTrivial.BasicCountdownTimer
import cat.itb.m78.exercices.PracticaTrivial.NavLivTrivial
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    NavLivTrivial()
}
