package com.example.bazar.feature.book_details.presentation.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bazar.feature.book_details.presentation.viewmodel.DetailsViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.core.presentation.utils.ErrorMessageSection
import com.example.bazar.core.presentation.utils.LoadingSection
import com.example.bazar.core.presentation.utils.ObserveAsEvent
import com.example.bazar.feature.book_details.presentation.viewmodel.DetailsEvent
import com.example.bazar.feature.home_screen.presentation.utils.toMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailsScreen() {

    val viewModel: DetailsViewModel = hiltViewModel()
    val state by viewModel.detailsState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var errorMessage by rememberSaveable {
        mutableStateOf("")
    }

    LaunchedEffect(true) {
        viewModel.getBookDetails("Simple Sabotage Field Manual")
    }

    ObserveAsEvent(viewModel.eventChannel) { event ->
        when (event) {
            is DetailsEvent.Error -> {
                Log.d("details error", event.error.toMessage(context))
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Book Details",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            ErrorMessageSection(errorMessage)
            LoadingSection(state.isLoading)
            Spacer(modifier = Modifier.height(10.dp))
            state.bookDetails?.let { details ->
                DetailsTopSection(details.thumbnail, context)
                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        details.title,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        details.authors.first(),
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                DetailsMiddleSection(details)
                Spacer(modifier = Modifier.height(16.dp))


                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Synopsis",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = details.description,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                    Spacer(modifier = Modifier.height(18.dp))


                }
            }
        }
    }

}