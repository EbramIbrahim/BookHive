package com.example.bazar.feature.book_details.domain.repository.remote

import com.example.bazar.feature.book_details.domain.model.BookDetails

interface BookDetailsRepository {
    suspend fun getBookDetails(bookName: String): BookDetails
}