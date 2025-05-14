package com.example.bazar.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.feature.onboarding.domain.local.repository.SaveSkipOnBoardingValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val repository: SaveSkipOnBoardingValue
) : ViewModel() {

    fun saveSkipOnBoarding() = viewModelScope.launch {
        repository.saveSkipOnBoarding()
    }

}