package com.example.bouwtjelopen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bouwtjelopen.domain.Building
import com.example.bouwtjelopen.ui.components.BuildingCard

@Composable
fun ProjectScreen(projectId: String, onBuildingClick: (Building) -> Unit = {}){
    var searchQuery by remember { mutableStateOf("") }

    val buildings = remember {
        listOf(
            Building(
                id = "W-001",
                name = "Woning 01",
                address = "Bouwstraat 12",
                type = "Woning",
                hasLogbook = true
            ),
            Building(
                id = "W-002",
                name = "Woning 02",
                address = "Bouwstraat 14",
                type = "Woning",
                hasLogbook = true
            ),
            Building(
                id = "A-101",
                name = "Appartement 101",
                address = "Bouwstraat 20",
                type = "Appartement",
                hasLogbook = false
            ),
            Building(
                id = "A-102",
                name = "Appartement 102",
                address = "Bouwstraat 20",
                type = "Appartement",
                hasLogbook = true
            )
        )
    }

    val filteredBuildings = buildings.filter {
        it.name.contains(searchQuery, ignoreCase = true) ||
                it.address.contains(searchQuery, ignoreCase = true) ||
                it.id.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Text(
            text = "Bouwplaats",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Woningen en appartementen",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))



        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text("Zoek woning of appartement")
            },
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "woningen/appartementen",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${filteredBuildings.size} woningen/appartementen",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                items = filteredBuildings,
                key = { it.id }
            ) { building ->

                BuildingCard(
                    building = building,
                    onClick = {
                        onBuildingClick(building)
                    }
                )
            }
        }
    }
}