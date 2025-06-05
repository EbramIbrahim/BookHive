package com.example.bazar.feature.onboarding.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.feature.onboarding.data.OnBoarding
import com.example.bazar.ui.theme.LocalTheme
import com.example.bazar.ui.theme.primaryColor

@Composable
fun OnBoardingScreen(
    onBoarding: OnBoarding,
    onClick: () -> Unit
) {

    val theme = LocalTheme.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(theme.surface)
            .padding(all = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                "Skip",
                style = theme.secondaryTextStyle.copy(color = theme.primaryColor),
                modifier = Modifier.clickable { onClick() }
            )
        }

        Image(
            modifier = Modifier.size(320.dp),
            painter = painterResource(onBoarding.image),
            contentDescription = onBoarding.title
        )

        Spacer(modifier = Modifier.height(14.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                onBoarding.title,
                style = theme.primaryTextStyle.copy(textAlign = TextAlign.Center),
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                onBoarding.subtitle,
                style = theme.hintTextStyle.copy(textAlign = TextAlign.Center),

                )
        }

    }
}

@Preview
@Composable
private fun OnBoardingPrev() {
    val onBoarding = OnBoarding(
        image = R.drawable.onboarding_1,
        title = "Now reading books\nwill be easier",
        subtitle = " Discover new worlds, join a vibrant\nreading community. Start your reading\nadventure effortlessly with us."
    )
    OnBoardingScreen(
        onBoarding,
        onClick = {}
    )
}



