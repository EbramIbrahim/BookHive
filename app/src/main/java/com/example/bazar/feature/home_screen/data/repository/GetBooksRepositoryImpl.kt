package com.example.bazar.feature.home_screen.data.repository


import com.example.bazar.feature.home_screen.data.mapper.toBooks
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.feature.home_screen.domain.repository.GetBooksRepository
import javax.inject.Inject

class GetBooksRepositoryImpl @Inject constructor(
    private val api: BooksApi
): GetBooksRepository {

    override suspend fun getBooks(
        queryMap: Map<String, Any>?
    ): List<Books> {
        val books = api.getBooks(
            queryMap = queryMap
        ).results.map { it.toBooks() }
        return books
    }
}