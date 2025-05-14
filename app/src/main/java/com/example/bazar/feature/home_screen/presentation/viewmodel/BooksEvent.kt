package com.example.bazar.feature.home_screen.presentation.viewmodel

import com.example.bazar.core.domain.utils.NetworkError

sealed interface BooksEvent {
    data class Error(val error: NetworkError): BooksEvent
}