package com.example.practice.ui.components.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.practice.domain.model.Project

@Composable
fun ProjectCard(
    project: Project,
    onClick: (Project) -> Unit
)
{
    Card(modifier = Modifier
        .fillMaxSize()
        .clickable { onClick(project) })
        {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(text = project.title)
                Text(text = project.projectNumber)
            }
        }
}

