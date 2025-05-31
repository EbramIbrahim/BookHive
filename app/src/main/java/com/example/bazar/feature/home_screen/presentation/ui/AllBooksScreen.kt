package com.example.bazar.feature.home_screen.presentation.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.R
import com.example.bazar.core.presentation.navigation.Screen
import com.example.bazar.core.presentation.ui.AnimatedSearchAppBar
import com.example.bazar.core.presentation.utils.ErrorMessageSection
import com.example.bazar.core.presentation.utils.LoadingSection
import com.example.bazar.core.presentation.utils.ObserveAsEvent
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.feature.home_screen.presentation.utils.toMessage
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksEvent
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllBooksScreen(navController: NavController) {
    val viewModel: BooksViewModel = hiltViewModel()
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
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            AnimatedSearchAppBar(
                onSearch = { query ->
                    viewModel.loadBooks(hashMapOf(Pair("search", query)))
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ErrorMessageSection(errorMessage)
            LoadingSection(state.isLoading)
            HorizontalDivider()

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.books) { book ->
                    AllBookCardSection(book, context, onCardClick = { bookName ->
                        navController.navigate(Screen.BookDetailsScreen(bookName))
                    })
                }
            }
        }
    }
}


@Composable
fun AllBookCardSection(
    book: Books,
    context: Context,
    onCardClick: (String) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                onCardClick(book.title)
            },
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(108.dp)
                    .height(178.dp),
                shape = RoundedCornerShape(8.dp)
            ) {

                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(context = context)
                        .data(book.bookImage)
                        .error(R.drawable.books_error)
                        .placeholder(R.drawable.books_in_progress)
                        .crossfade(enable = true)
                        .build(),
                    contentDescription = book.id.toString(),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Column {
                    Text(
                        book.title,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        book.authorName,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Column {
                    Text(
                        book.languages,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Text(
                        book.subjects.first(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}


