package cat.itb.m78.exercices.Stateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em


import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

data class Contact(val fullName: String, val email: String, val phone: String)
val contact = Contact("Marta Casserres", "marta@example.com", "934578484")

@Composable
fun ContactMethod(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,){
        Image(
            painter = painterResource(Res.drawable.generatedFace),
            modifier = Modifier
                .border(2.dp, Color.White, CircleShape)
                .clip(CircleShape)
                .size(200.dp),
        contentDescription = null
        )
        Text(contact.fullName, fontSize = 2.em, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp))
        Card{
            Column(modifier = Modifier.padding(30.dp)) {
                Row(modifier = Modifier.padding(bottom = 20.dp)){
                Icon(Icons.Default.Email, null)
                Text(contact.email)
            }
                Row(){
                    Icon(Icons.Default.Call, null)
                    Text(contact.phone)
                }
            }
        }
    }
}