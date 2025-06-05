package com.example.bazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import com.example.bazar.core.presentation.navigation.SetupNavHost
import com.example.bazar.ui.theme.BazarTheme
import com.example.bazar.ui.theme.LocalTheme
import com.example.bazar.ui.theme.darkThemeColors
import com.example.bazar.ui.theme.lightThemeColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val customTheme = if (isSystemInDarkTheme()) darkThemeColors else lightThemeColors
            CompositionLocalProvider(LocalTheme provides customTheme) {
                    SetupNavHost()
            }
        }
    }
}

