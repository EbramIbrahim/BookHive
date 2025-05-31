package com.example.bazar.core.presentation.navigation

import kotlinx.serialization.Serializable

interface Screen {

    @Serializable
    data object SplashScreen: Screen

    @Serializable
    data object OnBoardingScreen: Screen

    @Serializable
    data object HomeScreen: Screen

    @Serializable
    data object AllBooksScreen: Screen

    @Serializable
    data object BookDetailsScreen: Screen
}