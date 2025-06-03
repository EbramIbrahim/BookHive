package com.example.bazar.feature.book_details.domain.usecase

import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.core.domain.utils.onError
import com.example.bazar.core.domain.utils.onSuccess
import com.example.bazar.feature.book_details.domain.model.BookDetails
import com.example.bazar.feature.book_details.domain.repository.remote.BookDetailsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.nio.channels.UnresolvedAddressException

class BookDetailsUseCaseTest {


    private lateinit var repository: BookDetailsRepository
    private lateinit var useCase: BookDetailsUseCase

    @Before
    fun setUp() {
        repository = mockk()
        useCase = BookDetailsUseCase(repository)
    }


    @Test
    fun `should return BookDetails when call BookDetailsUseCase`() = runTest {

        // Given
        val bookDetails: BookDetails = mockk(relaxed = true)

        // When
        coEvery { repository.getBookDetails(any()) } returns bookDetails
        val res = useCase.invoke("")

        res.onSuccess {
            assertEquals(it, bookDetails)
        }
    }

    @Test
    fun `should return Network error when call BookDetailsUseCase`() = runTest {

        // Given
        val error = NetworkError.NO_INTERNET
        // When
        coEvery { repository.getBookDetails(any()) } throws UnresolvedAddressException()
        val res = useCase.invoke("")

        res.onError {
            assertEquals(it, error)
        }

    }

}








