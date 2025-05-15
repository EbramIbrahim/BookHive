package com.example.bazar.feature.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.bazar.R
import com.example.bazar.core.presentation.navigation.Screen
import com.example.bazar.ui.theme.primaryColor

@Composable
fun SplashScreen(navController: NavController) {

    val viewModel: SplashViewModel = hiltViewModel()
    val duration = viewModel.splashScreenDuration.collectAsStateWithLifecycle()

    LaunchedEffect(
        key1 = duration.value.splashDuration,
        key2 = duration.value.skipOnBoarding
    ) {
        if (!duration.value.splashDuration) {
            if (duration.value.skipOnBoarding) {
                navController.navigate(Screen.HomeScreen) {
                    popUpTo(Screen.SplashScreen) { inclusive = true }
                }
            } else {
                navController.navigate(Screen.OnBoardingScreen) {
                    popUpTo(Screen.SplashScreen) { inclusive = true }
                }
            }

        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryColor),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(
                modifier = Modifier.size(38.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "BookHive.",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}





