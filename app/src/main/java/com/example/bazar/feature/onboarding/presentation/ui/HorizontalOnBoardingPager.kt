package com.example.bazar.feature.onboarding.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bazar.R
import com.example.bazar.core.presentation.navigation.Screen
import com.example.bazar.core.presentation.ui.PrimaryCustomElevatedButton
import com.example.bazar.feature.onboarding.data.OnBoarding
import com.example.bazar.feature.onboarding.presentation.viewmodel.OnBoardingViewModel
import com.example.bazar.ui.theme.LocalTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalOnBoardingPager(
    navController: NavController
) {

    val viewModel: OnBoardingViewModel = hiltViewModel()
    val theme = LocalTheme.current

    val pages = listOf(
        OnBoarding(
            image = R.drawable.onboarding_1,
            title = "Now reading books\nwill be easier",
            subtitle = " Discover new worlds, join a vibrant\nreading community. Start your reading\nadventure effortlessly with us."
        ),
        OnBoarding(
            image = R.drawable.onboarding_2,
            title = "Your Bookish Soulmate\nAwaits",
            subtitle = "Let us be your guide to the perfect read\n.Discover books tailored to your tastes\nfor a truly rewarding experience."
        ),
        OnBoarding(
            image = R.drawable.onboarding_3,
            title = "Start Your Adventure",
            subtitle = "Start Your Adventure"
        )
    )

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(theme.surface)
    ) {
        HorizontalPager(
            state = pagerState,
            count = pages.size,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            OnBoardingScreen(
                pages[page],
                onClick = {
                    viewModel.saveSkipOnBoarding()
                    navController.navigate(Screen.HomeScreen)
                }
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .padding(horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                repeat(pages.size) { index ->
                    val isSelected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .width(if (isSelected) 18.dp else 8.dp)
                            .height(if (isSelected) 8.dp else 8.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFF707784),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(
                                color = if (isSelected) theme.primaryColor else theme.surface,
                                shape = CircleShape
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(28.dp))

            PrimaryCustomElevatedButton(
                backgroundColor = theme.primaryColor,
                buttonTitle =
                    if (pagerState.currentPage < 2) "Continue" else "Get Started",
                titleColor = theme.surface,
                onClick = {
                    if (pagerState.currentPage < 2) {
                        val nextPage = pagerState.currentPage + 1
                        scope.launch { pagerState.animateScrollToPage(nextPage) }
                    } else {
                        viewModel.saveSkipOnBoarding()
                        navController.navigate(Screen.HomeScreen)
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryCustomElevatedButton(
                backgroundColor = theme.surface,
                buttonTitle = "Sign in",
                titleColor = theme.primaryColor,
                onClick = {
                }
            )
        }

    }
}


@Preview
@Composable
private fun HorizontalOnBoardingPagerPrev() {
    HorizontalOnBoardingPager(navController = rememberNavController())
}






