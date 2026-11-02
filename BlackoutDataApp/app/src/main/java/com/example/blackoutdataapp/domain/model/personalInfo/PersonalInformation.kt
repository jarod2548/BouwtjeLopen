package com.example.blackoutdataapp.domain.model.personalInfo

data class PersonalInformation(
    val supplies: Supplies = Supplies(),
    val communication: Communication = Communication(),
    val warmth: Warmth = Warmth(),
    val medicine: Medicine = Medicine(),
    val hygiene: Hygiene = Hygiene(),
    val transport: Transport = Transport()
)