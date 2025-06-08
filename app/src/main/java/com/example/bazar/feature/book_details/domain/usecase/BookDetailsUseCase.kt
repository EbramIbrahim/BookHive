package com.example.bazar.feature.book_details.domain.usecase

import android.util.Log
import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.core.domain.utils.Result
import com.example.bazar.feature.book_details.domain.model.BookDetails
import com.example.bazar.feature.book_details.domain.repository.remote.BookDetailsRepository
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.nio.channels.UnresolvedAddressException
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class BookDetailsUseCase @Inject constructor(
    private val repository: BookDetailsRepository
) {
    suspend operator fun invoke(
        bookName: String
    ): Result<BookDetails, NetworkError> {
        return try {
            val response = repository.getBookDetails(bookName)
            Result.Success(response)
        } catch (_: UnresolvedAddressException) {
            Result.Error(NetworkError.NO_INTERNET)
        } catch (_: SerializationException) {
          Result.Error(NetworkError.SERIALIZATION)
        } catch (e: Exception) {
            coroutineContext.ensureActive()
            Result.Error(NetworkError.UNKNOWN)
        }
    }
}