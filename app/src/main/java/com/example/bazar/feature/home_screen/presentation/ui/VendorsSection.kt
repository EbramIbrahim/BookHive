package com.example.bazar.feature.home_screen.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bazar.R
import com.example.bazar.ui.theme.offerCardBackground


@Composable
fun VendorsSection(
    vendorImage: Int
) {


    Box(
        modifier = Modifier
            .size(120.dp)
            .background(offerCardBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(vendorImage),
            contentDescription = "vendor img"
        )
    }

}

@Preview
@Composable
private fun VendorsPrev() {
    VendorsSection(R.drawable.vendor_1)
}




