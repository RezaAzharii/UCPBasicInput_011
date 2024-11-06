package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Preview(showBackground = true)
@Composable
fun MainUcp (
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderSec()
        InputSec()
    }
}

@Composable
fun HeaderSec (){
    Box(
        modifier = Modifier
            .background(color = Color.Blue)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.p1),
                contentDescription = "",
                modifier = Modifier.size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "",
                    tint = Color.White

                )
                Text(
                    text = "Reza Azhari",
                    color = Color.White
                )
            }
            Row (
                modifier = Modifier
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "",
                    tint = Color.White

                )
                Text(
                    text = "Lampung",
                    color = Color.White
                )
            }

        }
    }
}

@Composable
fun InputSec(){
    var textorigin by remember { mutableStateOf("") }
    var textdeparture by remember { mutableStateOf("") }
    var textarrival by remember { mutableStateOf("") }
    var texttransport by remember { mutableStateOf("") }

    val listtransport = listOf("Bus", "Ship", "Train", "Plane")

    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var transport by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        Text(
            text = "Plan Your Advantures",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Text(
            text = "Let's plan an exquisite adventure",
            color = Color.Black
        )
        OutlinedTextField(
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = textorigin,
            onValueChange = {textorigin = it},
            label = { Text("Origin")},
            placeholder = { Text("Masukan Origin")}
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            OutlinedTextField(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .width(200.dp)
                    .padding(5.dp),
                value = textdeparture,
                onValueChange = {textdeparture = it},
                label = { Text("Departure")},
                placeholder = { Text("Masukan Departure")}
            )
            OutlinedTextField(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .width(200.dp)
                    .padding(5.dp),
                value = textarrival,
                onValueChange = {textarrival = it},
                label = { Text("Arrival")},
                placeholder = { Text("Masukan Arrival")}
            )
        }
        Row {
            listtransport.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = texttransport == item,
                        onClick = {
                            texttransport = item
                        }
                    )
                    Text(item)
                }
            }
        }
        Button (
            modifier = Modifier .fillMaxWidth(),
            onClick = {
            origin = textorigin
            departure = textdeparture
            arrival = textarrival
            transport    = texttransport
        }) {
            Text("Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.Blue),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .padding(horizontal = 8.dp)
            ) {
                DetailSurat(judul = "Origin", isinya = origin)
                DetailSurat(judul = "Departure", isinya = departure)
            }
        }
        Spacer(Modifier .padding(10.dp))
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.Blue),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .padding(horizontal = 8.dp)
            ) {
                DetailSurat(judul = "Arrival", isinya = arrival)
                DetailSurat(judul = "Transport", isinya = transport)
            }
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(6.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isinya,
            modifier = Modifier.weight(2f))
    }
}