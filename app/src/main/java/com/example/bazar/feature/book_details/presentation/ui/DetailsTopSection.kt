package com.example.bazar.feature.book_details.presentation.ui

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bazar.R

@Composable
fun DetailsTopSection(thumbnail: String, context: Context) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .blur(10.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = ImageRequest.Builder(context = context)
                    .data(thumbnail)
                    .build(),
                contentDescription = "",
                error = painterResource(R.drawable.books_error),
                placeholder = painterResource(R.drawable.books_in_progress),
                contentScale = ContentScale.FillBounds

            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 130.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                modifier = Modifier
                    .width(128.dp)
                    .height(188.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(context = context)
                        .data(thumbnail)
                        .build(),
                    contentDescription = "",
                    error = painterResource(R.drawable.books_error),
                    placeholder = painterResource(R.drawable.books_in_progress),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}


//                val imageLoader = remember {
//                    ImageLoader.Builder(context)
//                        .logger(DebugLogger())
//                        .components {
//                            //add(SvgDecoder.Factory())
//                        }
//                        .okHttpClient {
//                            OkHttpClient.Builder()
//                                .addInterceptor { chain ->
//                                    chain.proceed(
//                                        chain.request().newBuilder()
//                                            .header("User-Agent", "Mozilla/5.0 ...")
//                                            .build()
//                                    )
//                                }
//                                .build()
//                        }
//                        .build()
//                }
//
//                AsyncImage(
//                    model = ImageRequest.Builder(context)
//                        .data(thumbnail)
//                        .setHeader("User-Agent", "Mozilla/5.0 ...")
//                        .crossfade(true)
//                        .build(),
//                    contentDescription = "Book cover",
//                    imageLoader = imageLoader,
//                    modifier = Modifier
//                        .fillMaxSize(),  // Add border to verify container bounds
//                    error = painterResource(R.drawable.books_error),
//                    placeholder = painterResource(R.drawable.books_in_progress)
//                )