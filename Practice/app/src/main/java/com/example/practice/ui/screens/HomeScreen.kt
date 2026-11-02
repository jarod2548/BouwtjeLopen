package com.example.practice.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.practice.domain.model.Project
import com.example.practice.ui.components.Home.ProjectBox
import com.example.practice.ui.components.Home.ProjectCard

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onProjectClick:(Project) -> Unit){
    val projects : List<Project> = listOf(
        Project("Tilburg", "1"),
        Project("Feybreak", "2")
    )
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home"
        )
        ProjectBox(
            projects = projects,
            modifier = Modifier.weight(1f),
            onClick = onProjectClick
        )
    }
}

