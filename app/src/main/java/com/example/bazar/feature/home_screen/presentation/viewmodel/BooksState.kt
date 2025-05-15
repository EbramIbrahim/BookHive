package com.example.bazar.feature.home_screen.presentation.viewmodel

import com.example.bazar.feature.home_screen.domain.model.Books

data class BooksState(
    val isLoading: Boolean = false,
    val books: List<Books> = emptyList(),
    val offerBook: Books? = null,
)
