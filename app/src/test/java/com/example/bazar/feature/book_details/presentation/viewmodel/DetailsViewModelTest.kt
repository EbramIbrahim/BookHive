package com.example.bazar.feature.book_details.presentation.viewmodel

import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.feature.book_details.domain.model.BookDetails
import com.example.bazar.feature.book_details.domain.repository.remote.BookDetailsRepository
import com.example.bazar.feature.book_details.domain.usecase.BookDetailsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.nio.channels.UnresolvedAddressException

@OptIn(ExperimentalCoroutinesApi::class)
class DetailsViewModelTest {

    private lateinit var repository: BookDetailsRepository
    private lateinit var useCase: BookDetailsUseCase
    private lateinit var viewModel: DetailsViewModel

    @Before
    fun setUp() {
        repository = mockk()
        useCase = BookDetailsUseCase(repository)
        viewModel = DetailsViewModel(useCase)
    }

    @Test
    fun `should return state that contain bookDetails when calling getBookDetails`() = runTest {

        // Given
        val bookDetails: BookDetails = mockk(relaxed = true)

        // When
        coEvery { repository.getBookDetails(any()) } returns bookDetails
        viewModel.getBookDetails("")
        advanceUntilIdle()

        viewModel.detailsState.onEach { state ->
            assertEquals(state.bookDetails, bookDetails)
            assertEquals(state.isLoading, false)
        }.launchIn(this).cancel()

    }


    @Test
    fun `should return event that contain Network Error when calling getBookDetails`() = runTest {

        // Given
        val error = NetworkError.NO_INTERNET
        // When
        coEvery { repository.getBookDetails(any()) } throws UnresolvedAddressException()
        viewModel.getBookDetails("")
        advanceUntilIdle()

        viewModel.eventChannel.onEach { event ->
            assertEquals((event as DetailsEvent.Error).error, error)
        }.launchIn(this).cancel()

        viewModel.detailsState.onEach { state ->
            assertEquals(state.bookDetails, null)
            assertEquals(state.isLoading, false)
        }.launchIn(this).cancel()

    }

}












