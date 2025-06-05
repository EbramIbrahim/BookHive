package com.example.bazar.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class CustomTheme(
    val surface: Color,
    val primaryColor: Color,
    val secondaryButtonColor: Color,
    val primaryTextColor: Color,
    val inverseTextColor: Color,
    val secondaryTextColor: Color,
    val hintTextColor: Color,
    val cardColor: Color,
    val vendorColor: Color,
    val primaryTextStyle: TextStyle,
    val secondaryTextStyle: TextStyle,
    val hintTextStyle: TextStyle,
)


val lightThemeColors = CustomTheme(
    surface = Color.White,
    primaryColor = Color(0xFF352368),
    secondaryButtonColor = Color.White,
    primaryTextColor = Color.Black,
    inverseTextColor = Color.White,
    secondaryTextColor = Color(0xFF352368),
    hintTextColor = Color(0xFFA6A6A6),
    cardColor = Color(0xFFFAF9FD),
    vendorColor = Color(0xFFFAFAFA),
    primaryTextStyle = TextStyle(
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    secondaryTextStyle = TextStyle(
        color = Color.White,
        fontSize = 18.sp,
    ),
    hintTextStyle = TextStyle(
        color = Color(0xFFA6A6A6),
        fontSize = 16.sp,
    ),
)
val darkThemeColors = CustomTheme(
    surface = Color.White,
    primaryColor = Color(0xFF352368),
    secondaryButtonColor = Color.White,
    primaryTextColor = Color.Black,
    inverseTextColor = Color.White,
    secondaryTextColor = Color(0xFF352368),
    hintTextColor = Color.Gray,
    cardColor = Color(0xFFFAF9FD),
    vendorColor = Color(0xFFFAFAFA),
    primaryTextStyle = TextStyle(
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    secondaryTextStyle = TextStyle(
        color = Color.White,
        fontSize = 18.sp,
    ),
    hintTextStyle = TextStyle(
        color = Color(0xFFA6A6A6),
        fontSize = 18.sp,
    ),
)

val LocalTheme = staticCompositionLocalOf<CustomTheme>{
    error("No colors provided.")
}








