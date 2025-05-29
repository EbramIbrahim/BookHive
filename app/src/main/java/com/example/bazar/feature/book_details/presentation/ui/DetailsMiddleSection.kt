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


@OptIn(ExperimentalTextApi::class)
@Composable
fun DetailsMiddleSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray),
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
                append(" English")
            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            )
        )

        VerticalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Text(
            buildAnnotatedString {
                withAnnotation(
                    tag = "book",
                    annotation = ""
                ) {
                    append("\uD83D\uDCD6")
                }
                append(" 270")
            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            )
        )

        VerticalDivider(modifier = Modifier.padding(vertical = 8.dp))

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

@Preview
@Composable
private fun DetailsMiddleSectionPrev() {
    DetailsMiddleSection()
}



