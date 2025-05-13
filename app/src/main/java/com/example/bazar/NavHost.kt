package com.example.bazar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bazar.feature.splash.presentation.SplashScreen


@Composable
fun SetupNavHost(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.SplashScreen
    ) {
        composable<Screen.SplashScreen> {
            SplashScreen(navController)
        }
        composable<Screen.MainScreen> {
            Greeting("Abram Ibrahim")
        }
    }

}









