package com.example.bouwtje_lopen

import kotlinx.serialization.Serializable

@Serializable
sealed interface Navigation {
    @Serializable
    data object Home : Navigation
    @Serializable
    data class Project(
        val id : String
    ) : Navigation
}