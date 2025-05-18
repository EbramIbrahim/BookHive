package com.example.bazar.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bazar.feature.home_screen.presentation.ui.AllBooksScreen
import com.example.bazar.feature.home_screen.presentation.ui.HomeScreen
import com.example.bazar.feature.onboarding.presentation.ui.HorizontalOnBoardingPager
import com.example.bazar.feature.splash.presentation.SplashScreen


@Composable
fun SetupNavHost() {

    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen
    ) {
        composable<Screen.SplashScreen> {
            SplashScreen(navController)
        }
        composable<Screen.OnBoardingScreen> {
            HorizontalOnBoardingPager(navController)
        }
        composable<Screen.HomeScreen> {
            HomeScreen(context, navController)
        }
        composable<Screen.AllBooksScreen> {
            AllBooksScreen(context)
        }
    }

}









