package com.example.blackoutdataapp.ui

import kotlinx.serialization.Serializable

@Serializable
sealed interface Navigation {
    @Serializable
    data object Home : Navigation
    @Serializable
    data object Offline : Navigation
    @Serializable
    data object Connect : Navigation
    @Serializable
    data object PersonalInstructions : Navigation
    @Serializable
    data object Formulier : Navigation
    @Serializable
    data object Contact : Navigation
    @Serializable
    data object Instructions : Navigation
}