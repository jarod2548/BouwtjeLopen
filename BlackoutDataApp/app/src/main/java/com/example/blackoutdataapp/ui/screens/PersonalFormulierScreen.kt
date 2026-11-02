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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.blackoutdataapp.ui.Navigation
import com.example.blackoutdataapp.ui.components.AmountField
import com.example.blackoutdataapp.ui.components.BooleanField
import com.example.blackoutdataapp.ui.viewmodel.PersonalInformationVM

@Composable
fun PersonalFormulierScreen(modifier: Modifier = Modifier, onClick: (Navigation) -> Unit){
    val viewModel : PersonalInformationVM = hiltViewModel()


    LaunchedEffect(Unit) {
        viewModel.load()
    }

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
    ) { innerPadding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Water en voedsel",
                style = MaterialTheme.typography.headlineSmall
            )

            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    AmountField(
                        label = "Water",
                        value = viewModel.waterAmount,
                        onValueChange = {
                            viewModel.updateWaterAmount(it)
                        },
                        keyboardType = KeyboardType.Decimal
                    )

                    AmountField(
                        label = "Voedsel",
                        value = viewModel.foodAmount,
                        onValueChange = {
                            viewModel.updateFoodAmount(it)
                        },
                        keyboardType = KeyboardType.Decimal
                    )

                    AmountField(
                        label = "Droog voedsel",
                        value = viewModel.dryFoodAmount,
                        onValueChange = {
                            viewModel.updateDryFoodAmount(it)
                        },
                        keyboardType = KeyboardType.Decimal
                    )

                    AmountField(
                        label = "Zaklampen",
                        value = viewModel.flashlightAmount,
                        onValueChange = {
                            viewModel.updateFlashLightAmount(it)
                        },
                        keyboardType = KeyboardType.Number
                    )

                    AmountField(
                        label = "Opgeladen powerbanks",
                        value = viewModel.powerbankAmount,
                        onValueChange = {
                            viewModel.updatePowerBankAmount(it)
                        },
                        keyboardType = KeyboardType.Number
                    )
                    AmountField(
                        label = "Contant geld",
                        value = viewModel.moneyAmount,
                        onValueChange = {
                            viewModel.updateMoneyAmount(it)
                        },
                        keyboardType = KeyboardType.Number
                    )
                }
            }

            Text(
                text = "Communicatie",
                style = MaterialTheme.typography.headlineSmall
            )

            Card {
                Column {
                    BooleanField(
                        text = "Batterijradio",
                        checked = viewModel.hasBatteryRadio,
                        onCheckedChange = {
                            viewModel.updateBatteryRadio(it)
                        }
                    )

                    BooleanField(
                        text = "Telefoonnummers van familie/vrienden",
                        checked = viewModel.hasPhoneContact,
                        onCheckedChange = {
                            viewModel.updatePhoneContact(it)
                        }
                    )

                    BooleanField(
                        text = "Goed contact met de buren",
                        checked = viewModel.hasNeighbourContact,
                        onCheckedChange = {
                            viewModel.updateNeighbourContact(it)
                        }
                    )
                }
            }

            Text(
                text = "Warmte",
                style = MaterialTheme.typography.headlineSmall
            )

            Card {
                Column {
                    BooleanField(
                        text = "Genoeg warme kleding",
                        checked = viewModel.hasWarmClothes,
                        onCheckedChange = {
                            viewModel.updateWarmClothes(it)
                        }
                    )

                    BooleanField(
                        text = "Kan omgaan met extreme kou",
                        checked = viewModel.canHandleExtremeCold,
                        onCheckedChange = {
                            viewModel.updateHandleExtremeCold(it)
                        }
                    )
                }
            }

            Text(
                text = "Hygiëne",
                style = MaterialTheme.typography.headlineSmall
            )

            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    AmountField(
                        label = "Toiletpapier",
                        value = viewModel.toiletpaperAmount,
                        onValueChange = {
                            viewModel.updateToiletpaperAmount(it)
                        },
                        keyboardType = KeyboardType.Number
                    )

                    AmountField(
                        label = "Zeep",
                        value = viewModel.soapAmount,
                        onValueChange = {
                            viewModel.updateSoapAmount(it)
                        },
                        keyboardType = KeyboardType.Number
                    )

                    AmountField(
                        label = "Vuilniszakken",
                        value = viewModel.trashbagAmount,
                        onValueChange = {
                            viewModel.updateTrashbag(it)
                        },
                        keyboardType = KeyboardType.Number
                    )
                }
            }

            Text(
                text = "Vervoer en documenten",
                style = MaterialTheme.typography.headlineSmall
            )

            Card {
                Column {
                    BooleanField(
                        text = "Ik heb een fiets",
                        checked = viewModel.hasBike,
                        onCheckedChange = {
                            viewModel.updateHasBike(it)
                        }
                    )

                    BooleanField(
                        text = "Ik heb een auto met genoeg brandstof",
                        checked = viewModel.hasCarWithFuel,
                        onCheckedChange = {
                            viewModel.updateHasCarWithFuel(it)
                        }
                    )

                    BooleanField(
                        text = "Ik heb belangrijke documenten bij de hand",
                        checked = viewModel.hasImportantDocuments,
                        onCheckedChange = {
                            viewModel.updateHasImportantDocuments(it)
                        }
                    )
                }
            }

            Button(
                onClick = {
                    viewModel.save(
                        onSuccess ={
                            onClick(Navigation.PersonalInstructions)
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Opslaan")
            }
        }
    }
}
