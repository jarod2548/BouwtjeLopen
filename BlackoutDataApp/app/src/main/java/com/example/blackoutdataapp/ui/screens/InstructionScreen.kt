package com.example.blackoutdataapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blackoutdataapp.ui.Navigation

@Composable
fun InstructionScreen(modifier: Modifier = Modifier, onClick:(Navigation) -> Unit){
    var oneHourInstruction by remember { mutableStateOf(false) }
    var oneToSixHourInstruction by remember { mutableStateOf(false) }
    var sixTo24HourInstruction by remember { mutableStateOf(false) }
    var dayInstruction by remember { mutableStateOf(false) }
    Row()
    {
        Button(onClick = {
            onClick(Navigation.Home)
        }) {
            Text("Home")
        }
        Button(onClick = {onClick(Navigation.Offline)}) {
            Text("Vorige pagina")
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(onClick = {
            oneHourInstruction = !oneHourInstruction
        },modifier = Modifier.fillMaxWidth()) {
            Text("1 uur of minder")
        }
        if(oneHourInstruction){
            Text("de tekst die zichtbaar is als 1 uur instructie is zichtbaar")
        }

        Button(onClick = {
            oneToSixHourInstruction = !oneToSixHourInstruction
        },modifier = Modifier.fillMaxWidth()) {
            Text("1 - 6 uur")
        }
        if(oneToSixHourInstruction){
            Text("de tekst die zichtbaar is als 1-6 uur instructie is zichtbaar")
        }
        Button(onClick = {
            sixTo24HourInstruction = !sixTo24HourInstruction
        },modifier = Modifier.fillMaxWidth()) {
            Text("6 - 24 uur")
        }
        if(sixTo24HourInstruction){
            Text("de tekst die zichtbaar is als 6-24 uur instructie is zichtbaar")
        }
        Button(onClick = {
            dayInstruction = !dayInstruction
        },modifier = Modifier.fillMaxWidth()) {
            Text("meer dan 24 uur")
        }
        if(dayInstruction){
            Text("de tekst die zichtbaar is als 24+ uur instructie is zichtbaar")
        }

    }
}
