package com.example.bazar.feature.book_details.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bazar.core.domain.utils.onError
import com.example.bazar.core.domain.utils.onSuccess
import com.example.bazar.feature.book_details.domain.usecase.BookDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: BookDetailsUseCase
) : ViewModel() {


    private val _detailsState = MutableStateFlow(DetailsState())
    val detailsState = _detailsState.asStateFlow()


    private val _eventChannel = Channel<DetailsEvent>()
    val eventChannel = _eventChannel.receiveAsFlow()

    fun getBookDetails(bookName: String) {
        viewModelScope.launch {
            _detailsState.update { it.copy(isLoading = true) }
            useCase.invoke(bookName)
                .onSuccess { details ->
                    _detailsState.update { it.copy(bookDetails = details, isLoading = false) }
                }
                .onError {
                    _detailsState.update { it.copy(isLoading = false) }
                    _eventChannel.trySend(DetailsEvent.Error(it))
                }

        }
    }


}





















