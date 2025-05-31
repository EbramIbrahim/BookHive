package com.example.bazar.feature.book_details.data.model

data class BookDetailsDto(
    val items: List<Item>,
    val kind: String? = null,
    val totalItems: Int? = null
)