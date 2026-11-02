package com.example.blackoutdataapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blackoutdataapp.ui.Navigation
import com.example.blackoutdataapp.ui.components.Topbar


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
            startDestination = Navigation.Home,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<Navigation.Home> {
                HomeScreen(onClick = { navigation ->
                    navController.navigate(navigation)
                })
            }

            composable<Navigation.Offline> {
                OfflineScreen(onClick = {navigation ->
                    navController.navigate(navigation)
                })
            }
            composable<Navigation.Instructions>{
                InstructionScreen(onClick = {navigation ->
                    navController.navigate(navigation)
                })
            }
            composable<Navigation.PersonalInstructions> {
                PersonalInformationScreen(onClick = {navigation ->
                    navController.navigate(navigation)
                })
            }
            composable<Navigation.Formulier> {
            PersonalFormulierScreen(onClick = { navigation ->
                    navController.navigate(navigation)
                })
            }
            composable<Navigation.Contact>{
                ContactScreen(onClick = {navigation ->
                    navController.navigate(navigation)
                })
            }
        }
    }
}




