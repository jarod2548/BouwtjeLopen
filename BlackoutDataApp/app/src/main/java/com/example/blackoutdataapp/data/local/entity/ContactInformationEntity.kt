package com.example.blackoutdataapp.data.local.entity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity("contact_information")
data class ContactInformationEntity(
    @PrimaryKey
    val id : Long = 1,

    val apotheekContact : String = "",
    val politieContact : String = "",
    val huisartsContact : String = "",
    val schoolContact : String = "",
    val werkContact : String = ""
)
