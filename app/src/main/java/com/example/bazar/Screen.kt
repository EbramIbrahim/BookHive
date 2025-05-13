package com.example.bazar

interface Screen {

    @kotlinx.serialization.Serializable
    data object SplashScreen: Screen

    @kotlinx.serialization.Serializable
    data object MainScreen: Screen
}