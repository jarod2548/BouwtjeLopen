package com.example.blackoutdataapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackoutdataapp.data.local.entity.PersonalInformationEntity
import com.example.blackoutdataapp.domain.model.personalInfo.PersonalInformation
import com.example.blackoutdataapp.domain.repository.PersonalInformationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.toDoubleOrNull
@HiltViewModel
class PersonalInformationVM @Inject constructor(private val repository: PersonalInformationRepository) : ViewModel(){

    init {
        checkIfPersonalInformationExists()
    }
    var hasSavedPersonalInformation by mutableStateOf<Boolean?>(null)
        private set

    fun checkIfPersonalInformationExists() {
        viewModelScope.launch {
            hasSavedPersonalInformation = repository.exists()
        }
    }

    var waterAmount by mutableStateOf("")
    var foodAmount by mutableStateOf("")
    var dryFoodAmount by mutableStateOf("")
    var flashlightAmount by mutableStateOf("")
    var powerbankAmount by mutableStateOf("")
    var hasBatteryRadio by mutableStateOf(false)
    var hasPhoneContact by mutableStateOf(false)
    var hasNeighbourContact by mutableStateOf(false)
    var hasWarmClothes by mutableStateOf(false)
    var canHandleExtremeCold by mutableStateOf(false)
    var toiletpaperAmount by mutableStateOf("")
    var soapAmount by mutableStateOf("")
    var trashbagAmount by mutableStateOf("")
    var moneyAmount by mutableStateOf("")
    var hasBike by mutableStateOf(false)
    var hasCarWithFuel by mutableStateOf(false)
    var hasImportantDocuments by mutableStateOf(false)

    fun save(onSuccess: () -> Unit) {
        val entity = PersonalInformationEntity(
            waterAmount = waterAmount.toDoubleOrNull() ?: 0.0,
            foodAmount = foodAmount.toDoubleOrNull() ?: 0.0,
            dryFoodAmount = dryFoodAmount.toDoubleOrNull() ?: 0.0,

            flashLightAmount = flashlightAmount.toIntOrNull() ?: 0,
            powerBankAmount = powerbankAmount.toIntOrNull() ?: 0,

            hasBatteryRadio = hasBatteryRadio,
            hasPhoneNumberSaved = hasPhoneContact,
            hasNeighbourContact = hasNeighbourContact,

            hasWarmClothes = hasWarmClothes,
            canHandleExtremeCold = canHandleExtremeCold,

            toiletpaperAmount = toiletpaperAmount.toIntOrNull() ?: 0,
            soapAmount = soapAmount.toIntOrNull() ?: 0,
            trashBagAmount = trashbagAmount.toIntOrNull() ?: 0,

            contactMoneyAmount = moneyAmount.toIntOrNull() ?: 0,

            hasBike = hasBike,
            hasCarWithEnoughFuel = hasCarWithFuel,
            hasImportantDocuments = hasImportantDocuments
        )

        viewModelScope.launch {
            try{
                repository.save(entity)
                onSuccess()
            }catch (e : Exception){

            }
        }
    }

    fun load() {
        viewModelScope.launch {
            val data = repository.getPersonalInformation()

            if (data != null) {
                waterAmount = data.waterAmount.toString()
                foodAmount = data.foodAmount.toString()
                dryFoodAmount = data.dryFoodAmount.toString()
                flashlightAmount = data.flashLightAmount.toString()
                powerbankAmount = data.powerBankAmount.toString()

                hasBatteryRadio = data.hasBatteryRadio
                hasPhoneContact = data.hasPhoneNumberSaved
                hasNeighbourContact = data.hasNeighbourContact

                hasWarmClothes = data.hasWarmClothes
                canHandleExtremeCold = data.canHandleExtremeCold

                toiletpaperAmount = data.toiletpaperAmount.toString()
                soapAmount = data.soapAmount.toString()
                trashbagAmount = data.trashBagAmount.toString()

                moneyAmount = data.contactMoneyAmount.toString()

                hasBike = data.hasBike
                hasCarWithFuel = data.hasCarWithEnoughFuel
                hasImportantDocuments = data.hasImportantDocuments
            }
        }
    }

    fun updateWaterAmount(amount: String) {
        if (amount.toDoubleOrNull() != null || amount.isEmpty()) {
            waterAmount = amount
        }
    }

    fun updateFoodAmount(amount: String) {
        if (amount.toDoubleOrNull() != null || amount.isEmpty()) {
            foodAmount = amount
        }
    }

    fun updateDryFoodAmount(amount: String) {
        if (amount.toDoubleOrNull() != null || amount.isEmpty()) {
            dryFoodAmount = amount
        }
    }

    fun updateFlashLightAmount(amount: String) {
        if (amount.toIntOrNull() != null || amount.isEmpty()) {
            flashlightAmount = amount
        }
    }

    fun updatePowerBankAmount(amount: String) {
        if (amount.toIntOrNull() != null || amount.isEmpty()) {
            powerbankAmount = amount
        }
    }


    fun updateBatteryRadio(result: Boolean) {
        hasBatteryRadio = result
    }

    fun updatePhoneContact(result: Boolean) {
        hasPhoneContact = result
    }

    fun updateNeighbourContact(result: Boolean) {
        hasNeighbourContact = result
    }


    fun updateWarmClothes(result: Boolean) {
        hasWarmClothes = result
    }

    fun updateHandleExtremeCold(result: Boolean) {
        canHandleExtremeCold = result
    }


    fun updateToiletpaperAmount(amount: String) {
        if (amount.toIntOrNull() != null || amount.isEmpty()) {
            toiletpaperAmount = amount
        }
    }

    fun updateSoapAmount(amount: String) {
        if (amount.toIntOrNull() != null || amount.isEmpty()) {
            soapAmount = amount
        }
    }

    fun updateTrashbag(amount: String) {
        if (amount.toIntOrNull() != null || amount.isEmpty()) {
            trashbagAmount = amount
        }
    }


    fun updateMoneyAmount(amount: String) {
        if (amount.toIntOrNull() != null || amount.isEmpty()) {
            moneyAmount = amount
        }
    }


    fun updateHasBike(result: Boolean) {
        hasBike = result
    }

    fun updateHasCarWithFuel(result: Boolean) {
        hasCarWithFuel = result
    }

    fun updateHasImportantDocuments(result: Boolean) {
        hasImportantDocuments = result
    }
}