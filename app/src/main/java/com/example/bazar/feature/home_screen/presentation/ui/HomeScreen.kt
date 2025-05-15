package com.example.bazar.feature.home_screen.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bazar.core.presentation.utils.ErrorMessageSection
import com.example.bazar.core.presentation.utils.ObserveAsEvent
import com.example.bazar.core.presentation.utils.LoadingSection
import com.example.bazar.feature.home_screen.presentation.utils.toMessage
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksEvent
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksViewModel
import com.example.bazar.ui.theme.primaryColor

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<BooksViewModel>()
    val state by viewModel.booksState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var errorMessage by rememberSaveable {
        mutableStateOf("")
    }

    ObserveAsEvent(viewModel.eventChannel) { event ->
        when (event) {
            is BooksEvent.Error -> {
                errorMessage = event.error.toMessage(context)
            }
        }
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Home",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
            }
        }
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ErrorMessageSection(errorMessage)
            LoadingSection(state.isLoading)
            Spacer(modifier = Modifier.height(28.dp))

            state.offerBook?.let {
                OfferBookSection(
                    book = it,
                    context = context
                )
            }
            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Top of Week",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "See all",
                    style = TextStyle(
                        color = primaryColor,
                        fontSize = 18.sp,
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow{
                items(state.books.take(10)) {book ->
                    BookCardSection(
                        book = book,
                        context = context
                    )
                }
            }

        }
    }

}















