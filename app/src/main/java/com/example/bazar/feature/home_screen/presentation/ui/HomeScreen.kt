package com.example.bazar.feature.home_screen.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.bazar.core.data.utils.VendorsList.vendors
import com.example.bazar.core.presentation.navigation.Screen
import com.example.bazar.core.presentation.utils.ErrorMessageSection
import com.example.bazar.core.presentation.utils.LoadingSection
import com.example.bazar.core.presentation.utils.ObserveAsEvent
import com.example.bazar.core.presentation.utils.toMessage
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksEvent
import com.example.bazar.feature.home_screen.presentation.viewmodel.BooksViewModel
import com.example.bazar.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel: BooksViewModel = hiltViewModel()
    val state by viewModel.booksState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var errorMessage by rememberSaveable {
        mutableStateOf("")
    }
    val theme = LocalTheme.current


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
            .background(theme.surface),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(theme.surface),
                title = {
                    Text(
                        text = "Home",
                        style = theme.primaryTextStyle
                    )
                }
            )
        }
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(theme.surface),
        ) {
            ErrorMessageSection(errorMessage)
            LoadingSection(state.isLoading)
            Spacer(modifier = Modifier.height(38.dp))

            state.offerBook?.let {
                OfferBookSection(
                    book = it,
                    context = context,
                    navController = navController
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Top of Week",
                        style = theme.primaryTextStyle
                    )
                    Text(
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.AllBooksScreen)
                        },
                        text = "See all",
                        style = theme.secondaryTextStyle.copy(color = theme.primaryColor)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.books.takeLast(10)) { book ->
                        BookCardSection(
                            book = book,
                            context = context
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Best Vendors",
                        style = theme.primaryTextStyle
                    )
                    Text(
                        text = "See all",
                        style = theme.secondaryTextStyle.copy(color = theme.primaryColor)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(vendors) { vendor ->
                        VendorsSection(vendor)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TestUi() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(it)) {

        }
    }
}









