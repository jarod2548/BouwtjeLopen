package com.example.blackoutdataapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blackoutdataapp.ui.Navigation

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClick:(Navigation) -> Unit ){
    Text(text = "Home", modifier = modifier)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(onClick = {
            null
        },modifier = Modifier.fillMaxWidth()) {
            Text("Verbinding maken met de game")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            onClick(Navigation.Offline)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Offline functies")
        }
    }


}