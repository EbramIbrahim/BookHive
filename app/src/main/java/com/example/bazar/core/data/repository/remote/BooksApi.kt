package com.example.bazar.core.data.repository.remote

import com.example.bazar.feature.home_screen.data.model.BooksModelDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface BooksApi {
    @GET("books")
    @JvmSuppressWildcards
    suspend fun getBooks(
        @QueryMap queryMap: Map<String, Any>?
    ): BooksModelDto
}