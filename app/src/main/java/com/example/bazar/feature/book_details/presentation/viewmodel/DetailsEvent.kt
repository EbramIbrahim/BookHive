package com.example.bazar.feature.book_details.presentation.viewmodel

import com.example.bazar.core.domain.utils.NetworkError

sealed interface DetailsEvent {
    data class Error(val error: NetworkError): DetailsEvent
}