package com.example.blackoutdataapp.domain.model.personalInfo

data class Transport(
    val contactMoneyAmount : Int = 0,
    val hasBike : Boolean = false,
    val hasCarWithEnoughFuel : Boolean = false,
    val hasTools : Boolean = false,
    val hasImportantDocuments : Boolean = false
)
