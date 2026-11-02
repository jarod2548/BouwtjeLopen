package com.example.blackoutdataapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.blackoutdataapp.ui.Navigation
import com.example.blackoutdataapp.ui.viewmodel.AiAnalysisVM
import com.example.blackoutdataapp.ui.viewmodel.PersonalInformationVM

@Composable
fun PersonalInformationScreen(modifier: Modifier = Modifier,onClick : (Navigation) -> Unit){
    val personalInformationVM : PersonalInformationVM = hiltViewModel()
    val aiAnalyseVM : AiAnalysisVM = hiltViewModel()
    Row()
    {
        Button(onClick = {
            onClick(Navigation.Home)
        }) {
            Text("Home")
        }
        Button(onClick = {onClick(Navigation.Offline)}) {
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
        when (aiAnalyseVM.hasSavedAiAnalyse){
            null -> {

            }
            true -> {

            }
            false -> {

            }
        }

        when (personalInformationVM.hasSavedPersonalInformation) {
            null -> {
                Text("Gegevens controleren...")
            }

            true -> {
                Text("Je persoonlijke gegevens zijn al opgeslagen.")
                Button(onClick = {
                    onClick(Navigation.Formulier)}
                ) {
                    Text("Pas persoonlijke gegevens aan")
                }
            }

            false -> {
                Text("Je hebt nog geen persoonlijke gegevens opgeslagen.")
                Button(onClick = {
                    onClick(Navigation.Formulier)}
                ) {
                    Text("Vul een formulier in")
                }
            }
        }

    }

}