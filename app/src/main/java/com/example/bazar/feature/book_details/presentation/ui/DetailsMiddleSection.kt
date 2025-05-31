package com.example.bazar.feature.book_details.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.core.presentation.ui.langCodeToLangName
import com.example.bazar.feature.book_details.domain.model.BookDetails


@OptIn(ExperimentalTextApi::class)
@Composable
fun DetailsMiddleSection(details: BookDetails) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            buildAnnotatedString {
                withAnnotation(
                    tag = "language",
                    annotation = ""
                ) {
                    append("\uD83C\uDF10")
                }
                append(" ${details.language.langCodeToLangName()}")
            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            )
        )

        VerticalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.Black)

        Text(
            buildAnnotatedString {
                withAnnotation(
                    tag = "book",
                    annotation = ""
                ) {
                    append("\uD83D\uDCD6")
                }
                append(" ${details.pageCount}")
            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            )
        )

        VerticalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.Black)

        Text(
            buildAnnotatedString {
                withAnnotation(
                    tag = "book",
                    annotation = ""
                ) {
                    append("📥")
                }
                append(" 20.5k")
            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            )
        )

    }
}




