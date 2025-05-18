package com.example.bazar.feature.home_screen.domain.model


data class Books(
    val bookshelves: List<String>,
    val copyright: Boolean,
    val downloadCount: Int,
    val id: Int,
    val languages: String,
    val mediaType: String,
    val subjects: List<String>,
    val title: String,
    val bookImage: String,
    val authorName: String
)

