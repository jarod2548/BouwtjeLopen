package com.example.practice.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.ui.components.Topbar

@Composable
fun App(){

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Topbar() },
        modifier = Modifier.fillMaxSize()
    )
    {

        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                HomeScreen(onProjectClick = {project ->
                    navController.navigate("project/${project.projectNumber}")
                })
            }

            composable("profile") {
                ProfileScreen()
            }
            composable("project/{projectNumber}"){
                ProfileScreen()
            }
        }
    }
}


