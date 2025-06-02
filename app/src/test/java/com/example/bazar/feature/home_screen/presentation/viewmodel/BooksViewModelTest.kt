package com.example.bazar.feature.home_screen.presentation.viewmodel

import app.cash.turbine.test
import com.example.bazar.MainDispatcherRule
import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.core.domain.utils.Result
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.feature.home_screen.domain.usecase.GetBooksUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BooksViewModelTest {


    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    private lateinit var useCase: GetBooksUseCase
    private lateinit var viewModel: BooksViewModel


    @Before
    fun setUp() {
        useCase = mockk()
        viewModel = BooksViewModel(useCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test viewmodel`() = runTest {

        val booksList: List<Books> = listOf(
            Books(emptyList(), false, 0, 0, "", "", emptyList(), "", "", ""),
            Books(emptyList(), false, 0, 0, "", "", emptyList(), "", "", ""),
        )

        coEvery { useCase.invoke(any()) } returns Result.Success(booksList)

        advanceUntilIdle()
        viewModel.booksState.test {
            assertEquals(false, awaitItem().isLoading)
            assertEquals(booksList, awaitItem().books)
        }
    }


}










