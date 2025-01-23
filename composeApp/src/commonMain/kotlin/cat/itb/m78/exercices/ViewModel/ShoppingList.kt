package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.Stateless.messages

data class Products(val name: String, val amount: Int)

class ViewModelShoppingList : ViewModel(){
    var textFieldNameViewModel = mutableStateOf("")
    var textFieldAmountViewModel = mutableStateOf(0)
    var listShoppingList = mutableStateOf(listOf<Products>())
    fun addShoppingList() {
        if (textFieldNameViewModel.value.isNotEmpty() && textFieldAmountViewModel.value > 0) {
            listShoppingList.value += Products(textFieldNameViewModel.value, textFieldAmountViewModel.value)
            textFieldNameViewModel.value = ""
            textFieldAmountViewModel.value = 0
        }
    }
}

@Composable
fun ShoppingList(){
    val viewModel = viewModel { ViewModelShoppingList() }
    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                TextField(
                    value = viewModel.textFieldNameViewModel.value,
                    onValueChange = { viewModel.textFieldNameViewModel.value = it },
                    label = { Text("Name") }
                )
                TextField(
                    value = viewModel.textFieldAmountViewModel.value.toString(),
                    onValueChange = {
                        viewModel.textFieldAmountViewModel.value = it.toIntOrNull() ?: 0
                    },
                    label = { Text("Amount") }
                )

                Button(onClick = {
                    viewModel.addShoppingList() })
                {
                    Text(text = "Add")
                }
            }
        }
    }
    LazyColumn(
        modifier = Modifier.padding(top = 200.dp)
    ) {
        items(viewModel.listShoppingList.value) { product ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(color = Gray),
            ) {
                Text(text = product.name, fontSize = 18.sp)
                Text(text = product.amount.toString(), fontSize = 18.sp)
            }
        }
    }
}
