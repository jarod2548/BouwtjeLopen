package com.example.blackoutdataapp.domain.model.personalInfo

data class Communication(
    val hasBatteryRadio : Boolean = false,
    val hasPhoneNumberSaved : Boolean = false,
    val hasNeighbourContact : Boolean = false
)
