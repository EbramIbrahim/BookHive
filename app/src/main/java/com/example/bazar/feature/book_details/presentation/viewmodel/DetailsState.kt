package com.example.bazar.feature.book_details.presentation.viewmodel

import com.example.bazar.feature.book_details.domain.model.BookDetails

data class DetailsState(
    val isLoading: Boolean = false,
    val bookDetails: BookDetails? = null,
)