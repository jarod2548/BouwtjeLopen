package com.example.blackoutdataapp.data.local.entity

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity("personal_information")
data class PersonalInformationEntity(
    @PrimaryKey
    val id : Long = 1,

    val waterAmount : Double = 0.0,
    val foodAmount : Double = 0.0,
    val dryFoodAmount : Double = 0.0,
    val flashLightAmount : Int = 0,
    val powerBankAmount : Int = 0,

    val hasBatteryRadio : Boolean = false,
    val hasPhoneNumberSaved : Boolean = false,
    val hasNeighbourContact : Boolean = false,

    val hasWarmClothes : Boolean = false,
    val canHandleExtremeCold : Boolean = false,

    val hasEHBO : Boolean = false,
    val hasColdMedicine : Boolean = false,
    val hasEnoughMedicine : Boolean = false,

    val toiletpaperAmount : Int = 0,
    val soapAmount : Int = 0,
    val trashBagAmount : Int = 0,

    val contactMoneyAmount : Int = 0,
    val hasBike : Boolean = false,
    val hasCarWithEnoughFuel : Boolean = false,
    val hasTools : Boolean = false,
    val hasImportantDocuments : Boolean = false
)