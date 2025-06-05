package com.example.bazar.feature.home_screen.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bazar.ui.theme.LocalTheme


@Composable
fun VendorsSection(
    vendorImage: Int
) {


    val theme = LocalTheme.current

    Box(
        modifier = Modifier
            .size(120.dp)
            .background(theme.vendorColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(vendorImage),
            contentDescription = "vendor img"
        )
    }

}




