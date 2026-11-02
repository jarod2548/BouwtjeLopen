package com.example.practice.ui.components.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practice.domain.model.Project

@Composable
fun ProjectBox(
    projects: List<Project>,
    modifier: Modifier = Modifier,
    onClick: (Project) -> Unit
) {
    Column(
        modifier = modifier.padding(
            horizontal = 16.dp
        ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        for (project in projects) {
            ProjectCard(project, onClick)
        }
    }
}