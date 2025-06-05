package com.example.bazar.feature.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.feature.onboarding.domain.local.repository.SaveSkipOnBoardingValue
import com.example.bazar.feature.splash.domain.local.repository.GetSkipOnBoardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: GetSkipOnBoardingRepository
) : ViewModel() {
    private val _splashScreenDuration = MutableStateFlow(SplashState())
    val splashScreenDuration = _splashScreenDuration
        .onStart {
            initState()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            SplashState()
        )

    fun initState() {
        viewModelScope.launch {
            val result = repository.getKey()
            delay(1000)
            _splashScreenDuration.update { it.copy(splashDuration = false, skipOnBoarding = result == true) }

        }
    }



}