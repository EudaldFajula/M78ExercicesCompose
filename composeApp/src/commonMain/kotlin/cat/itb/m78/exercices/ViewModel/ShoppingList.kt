package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.Stateless.messages

data class Products(val name: String, val amount: Int)

class ViewModelShoppingList : ViewModel(){
    var textFieldNameViewModel = mutableStateOf("")
    var textFieldAmountViewModel = mutableStateOf("")
    var listShoppingList = mutableStateOf(listOf<Products>())
    fun addShoppingList(){
        listShoppingList
    }
}

@Composable
fun ShoppingList(){
    val viewModel = viewModel { ViewModelShoppingList() }
    var textFieldName = viewModel.textFieldNameViewModel.value
    var textFieldAmount = viewModel.textFieldAmountViewModel.value
    Column {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(textFieldName,
                label = {Text("Name")},
                onValueChange = {textFieldName = it})
            TextField(
                textFieldAmount,
                onValueChange = {textFieldAmount = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = {Text("Amount")})
        }
        Button(onClick = {

        }){Text("Add")}
    }
}