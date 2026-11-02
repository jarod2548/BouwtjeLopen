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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blackoutdataapp.ui.Navigation

@Composable
fun OfflineScreen(modifier: Modifier = Modifier, onClick:(Navigation) -> Unit ){
    Text(text = "Home", modifier = modifier)
    Row()
    {
        Button(onClick = {
            onClick(Navigation.Home)
        }) {
            Text("Home")
        }
        Button(onClick = {onClick(Navigation.Home)}) {
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
            onClick(Navigation.Contact)
        },modifier = Modifier.fillMaxWidth()) {
            Text("Contactinformatie")
        }
        Button(onClick = {
            onClick(Navigation.PersonalInstructions)
        },modifier = Modifier.fillMaxWidth()) {
            Text("Gepersonaliseerde instructies")
        }
        Button(onClick = {
            onClick(Navigation.Instructions)
        },modifier = Modifier.fillMaxWidth()) {
            Text("Noodsituatie instructies")
        }
    }

}
