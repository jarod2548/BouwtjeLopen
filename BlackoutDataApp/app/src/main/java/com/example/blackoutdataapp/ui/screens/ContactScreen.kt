package com.example.blackoutdataapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.blackoutdataapp.ui.Navigation
import com.example.blackoutdataapp.ui.components.AmountField
import com.example.blackoutdataapp.ui.components.BooleanField

@Composable
fun ContactScreen(modifier: Modifier = Modifier, onClick : (Navigation) -> Unit){
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        onClick(Navigation.Offline)
                    }
                ) {
                    Text("← Vorige")
                }

                Text(
                    text = "Persoonlijke informatie",
                    modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    ){ innerPadding ->

    Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Contact informatie",
            style = MaterialTheme.typography.headlineSmall
        )

        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Nood nummer")
                Text("112")
            }
        }


    }
    }
}

