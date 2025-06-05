package com.example.bazar.feature.home_screen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.core.domain.utils.onError
import com.example.bazar.core.domain.utils.onSuccess
import com.example.bazar.feature.home_screen.domain.usecase.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BooksViewModel @Inject constructor(
    private val useCase: GetBooksUseCase
) : ViewModel() {

    private val _booksState = MutableStateFlow(BooksState())
    val booksState = _booksState
        .onStart {
            loadBooks(hashMapOf(Pair("search", "")))
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            BooksState()
        )

    private val _eventChannel = Channel<BooksEvent>()
    val eventChannel = _eventChannel.receiveAsFlow()

    fun loadBooks(queryMap: Map<String, Any>?) {
        viewModelScope.launch {
            _booksState.update { it.copy(isLoading = true) }
            useCase.invoke(queryMap)
                .onSuccess { books ->
                    _booksState.update {
                        it.copy(
                            books = books,
                            offerBook = books.random(),
                            isLoading = false
                        )
                    }
                }
                .onError {
                    _eventChannel.trySend(BooksEvent.Error(it))
                    _booksState.update { it.copy(isLoading = false) }

                }
        }
    }
}


