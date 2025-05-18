package com.example.bazar.feature.home_screen.domain.repository


import com.example.bazar.feature.home_screen.domain.model.Books

interface GetBooksRepository {
    suspend fun getBooks(
        queryMap: Map<String, Any>?
    ): List<Books>
}