package com.example.bazar.feature.home_screen.domain.usecase

import android.util.Log
import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.core.domain.utils.Result
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.feature.home_screen.domain.repository.GetBooksRepository
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.nio.channels.UnresolvedAddressException
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class GetBooksUseCase @Inject constructor(
    private val repository: GetBooksRepository
) {

    suspend operator fun invoke(
        queryMap: Map<String, Any>?
    ): Result<List<Books>, NetworkError> {
        return try {
            val response = repository.getBooks(queryMap)
            Result.Success(response)
        } catch (_: UnresolvedAddressException) {
            Result.Error(NetworkError.NO_INTERNET)
        } catch (_: SerializationException) {
            Result.Error(NetworkError.SERIALIZATION)
        } catch (e: Exception) {
            Log.d("home State", e.message.toString())
            coroutineContext.ensureActive()
            Result.Error(NetworkError.UNKNOWN)
        }
    }
}








