package com.example.bazar.feature.home_screen.presentation.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.feature.home_screen.domain.model.Books
import com.example.bazar.ui.theme.offerCardBackground
import com.example.bazar.R



@Composable
fun OfferBookSection(
    book: Books,
    context: Context
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(146.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(offerCardBackground),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Column(
                modifier = Modifier.padding(start = 23.dp, top = 24.dp, bottom = 24.dp)
            ) {
                Text(
                    text = "Special Offer",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Discount 25%",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = {}
                ) {
                    Text(text = "View Details")
                }
            }

            AsyncImage(
                model = ImageRequest.Builder(context = context)
                    .data(book.bookImage)
                    .error(R.drawable.books_error)
                    .placeholder(R.drawable.books_in_progress)
                    .crossfade(enable = true)
                    .build(),
                contentDescription = book.id.toString(),
                modifier = Modifier
                    .fillMaxHeight(),
                contentScale = ContentScale.Fit
            )
        }
    }
}











