package com.example.bazar.feature.home_screen.data.model

data class BooksModelDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)