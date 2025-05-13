package com.example.bazar.feature.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {
    private val _splashScreenDuration = MutableStateFlow(true)
    val splashScreenDuration = _splashScreenDuration.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            _splashScreenDuration.value = false
        }
    }
}