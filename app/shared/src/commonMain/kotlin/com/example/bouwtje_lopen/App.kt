package com.example.bouwtje_lopen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.bouwtjelopen.screens.HomeScreen
import com.example.bouwtjelopen.screens.ProjectScreen

import com.example.bouwtjelopen.ui.components.Topbar

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Topbar()
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Navigation.Home,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<Navigation.Home> {
                HomeScreen(
                    onProjectClick = { project ->
                        navController.navigate(
                            Navigation.Project(
                                id = project.id
                            )
                        )
                    }
                )
            }

            composable<Navigation.Project> { backStackEntry ->

                val project = backStackEntry.toRoute<Navigation.Project>()

                ProjectScreen(
                    projectId = project.id
                )
            }
        }
    }
}