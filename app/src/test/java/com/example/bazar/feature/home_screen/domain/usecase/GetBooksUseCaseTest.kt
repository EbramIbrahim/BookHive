package com.example.bazar.feature.home_screen.domain.usecase

import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.core.domain.utils.onError
import com.example.bazar.core.domain.utils.onSuccess
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.feature.home_screen.domain.repository.GetBooksRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.nio.channels.UnresolvedAddressException

class GetBooksUseCaseTest {


    private lateinit var repository: GetBooksRepository

    @Before
    fun setUp() {
        repository = mockk()
    }


    @Test
    fun `Given empty queries Then return all books when called GetAllBooks method`() = runTest {

        // Given
        val booksList: List<Books> = mockk(relaxed = true)
        val useCase = GetBooksUseCase(repository)

        // Then
        coEvery { repository.getBooks(hashMapOf()) } returns booksList

        // When
        val result = useCase.invoke(hashMapOf())

        result.onSuccess {
            assertEquals(it, booksList)
        }

    }

    @Test()
    fun `Given empty queries Then throw exception when called GetAllBooks method`() = runTest {

        // Given
        val useCase = GetBooksUseCase(repository)

        // Then
        coEvery { repository.getBooks(hashMapOf()) } throws UnresolvedAddressException()

        // When
        val result = useCase.invoke(hashMapOf())

        result.onError {
            print(it)
            print(NetworkError.NO_INTERNET)
            assertEquals(it, NetworkError.NO_INTERNET)
        }

    }

}