package com.example.bazar.feature.home_screen.presentation.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.R
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.ui.theme.LocalTheme

@Composable
fun BookCardSection(
    book: Books,
    context: Context
) {
    val theme = LocalTheme.current

    Column(
        modifier = Modifier
            .width(127.dp)
            .height(198.dp)
    ) {
        Card(
            modifier = Modifier
                .width(127.dp)
                .height(150.dp),
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
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.width(127.dp),
            text = book.title,
            style = theme.secondaryTextStyle.copy(color = theme.primaryTextColor),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "$14.99",
            style = theme.secondaryTextStyle.copy(color = theme.primaryColor, fontSize = 16.sp),
            )
    }
}





