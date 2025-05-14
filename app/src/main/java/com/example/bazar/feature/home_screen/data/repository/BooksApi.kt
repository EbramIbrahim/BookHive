package com.example.bazar.feature.home_screen.data.repository

import com.example.bazar.feature.home_screen.data.model.BooksModelDto
import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    suspend fun getBooks(): BooksModelDto
}