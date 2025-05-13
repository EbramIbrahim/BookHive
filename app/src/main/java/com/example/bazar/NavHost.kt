package com.example.bazar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bazar.feature.onboarding.presentation.HorizontalOnBoardingPager
import com.example.bazar.feature.splash.presentation.SplashScreen


@Composable
fun SetupNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen
    ) {
        composable<Screen.SplashScreen> {
            SplashScreen(navController)
        }
        composable<Screen.OnBoardingScreen> {
            HorizontalOnBoardingPager()
        }
    }

}









