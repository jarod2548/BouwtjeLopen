package com.example.blackoutdataapp.data.local.entity

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity("ai_information")
data class AiAnalyseEntity(
    @PrimaryKey
    val id : Int = 1,

    val sterktes : String,
    val zwaktes : String,
    val aanbeveling : String
)
