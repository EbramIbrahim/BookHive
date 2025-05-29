package com.example.bazar.feature.book_details.data.repository.remote

import com.example.bazar.feature.book_details.data.model.BookDetailsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BookDetailsRemoteService {

    @GET("volumes")
    suspend fun getBookDetailsByName(
        @Query("q") bookName: String
    ): BookDetailsDto

}