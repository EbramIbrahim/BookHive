package com.example.bazar.feature.home_screen.presentation.viewmodel

import app.cash.turbine.test
import com.example.bazar.MainDispatcherRule
import com.example.bazar.core.domain.utils.NetworkError
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.feature.home_screen.domain.repository.GetBooksRepository
import com.example.bazar.feature.home_screen.domain.usecase.GetBooksUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.nio.channels.UnresolvedAddressException


@OptIn(ExperimentalCoroutinesApi::class)
class BooksViewModelTest {


    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var repository: GetBooksRepository
    private lateinit var useCase: GetBooksUseCase
    private lateinit var viewModel: BooksViewModel


    @Before
    fun setUp() {
        repository = mockk()
        useCase = GetBooksUseCase(repository)
        viewModel = BooksViewModel(useCase)
    }

    @Test
    fun `should return BookList when calling GetBooksUseCase`() = runTest {

        // Given
        val booksList: List<Books> = listOf(
            Books(emptyList(), false, 0, 0, "", "", emptyList(), "", "", ""),
            Books(emptyList(), false, 0, 0, "", "", emptyList(), "", "", ""),
        )

        //When
        coEvery { repository.getBooks(any()) } coAnswers { booksList }
        viewModel.loadBooks(hashMapOf())
        val state = viewModel.booksState

        advanceUntilIdle()
        state.test {
            assertEquals(false, awaitItem().isLoading)
            assertEquals(booksList, awaitItem().books)
        }
    }

    @Test
    fun `should return NetworkError when calling GetBooksUseCase `() = runTest {

        coEvery { repository.getBooks(any()) } throws UnresolvedAddressException()

        viewModel.loadBooks(hashMapOf())
        advanceUntilIdle()

        viewModel.eventChannel.onEach { event ->
            assertEquals((event as BooksEvent.Error).error, NetworkError.NO_INTERNET)
        }.launchIn(this).cancel()

    }

//    @Test
//    fun `test flow sequentially`() = runTest {
//        val flow = flow {
//            for (i in 1..3){
//                emit(i)
//                println("$i from emitter")
//                delay(200)
//            }
//        }
//        val res = mutableListOf<Int>()
//        flow.collect {
//            res.add(it)
//            println("$it from collector")
//        }
//        assertEquals(listOf(1,2,3), res)
//    }
//
//    @Test
//    fun `test flow in Parallel`() = runTest {
//        val flow = flow {
//            for (i in 1..3) {
//                emit(i)
//                println("$i from emitter")
//                delay(200)
//            }
//        }
//        val res = mutableListOf<Int>()
//        flow.onEach {
//            res.add(it)
//            println("$it from collector")
//        }.launchIn(this)
//        advanceUntilIdle()
//        assertEquals(listOf(1, 2, 3), res)
//    }

}










