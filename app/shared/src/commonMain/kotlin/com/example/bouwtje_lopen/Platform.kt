package com.example.bouwtje_lopen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform