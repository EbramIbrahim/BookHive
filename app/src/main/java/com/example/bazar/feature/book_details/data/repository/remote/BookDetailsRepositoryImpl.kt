package com.example.bazar.feature.book_details.data.repository.remote

import com.example.bazar.feature.book_details.data.mapper.toBookDetails
import com.example.bazar.feature.book_details.domain.model.BookDetails
import com.example.bazar.feature.book_details.domain.repository.remote.BookDetailsRepository
import javax.inject.Inject

class BookDetailsRepositoryImpl @Inject constructor(
    private val remoteService: BookDetailsRemoteService
): BookDetailsRepository {

    override suspend fun getBookDetails(bookName: String): BookDetails {
        val response = remoteService.getBookDetailsByName(bookName)

        val bookDetails = response.items.map { it.volumeInfo?.toBookDetails() }.first()
        return bookDetails!!
    }
}











