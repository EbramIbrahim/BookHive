package com.example.bazar.feature.home_screen.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bazar.feature.home_screen.presentation.utils.toMessage
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksEvent
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksViewModel

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<BooksViewModel>()
    val state = viewModel.booksState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Log.d("home State", state.value.books.toString())
    LaunchedEffect(true) {
        viewModel.eventChannel.collect {
            when(it) {
                is BooksEvent.Error -> {
                    Log.d("home State", it.error.toMessage(context))
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        if (state.value.books.isNotEmpty()) {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = state.value.books.toString()
            )
        }



    }
}















