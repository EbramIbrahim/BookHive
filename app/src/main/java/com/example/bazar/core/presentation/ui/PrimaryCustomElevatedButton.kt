package com.example.bazar.core.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.ui.theme.primaryColor


@Composable
fun PrimaryCustomElevatedButton(
    backgroundColor: Color,
    buttonTitle: String,
    titleColor: Color,
    onClick: () -> Unit
) {

    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = buttonTitle,
            style = TextStyle(
                fontSize = 16.sp,
                color = titleColor
            )
        )
    }


}


@Preview
@Composable
private fun ButtonPrev() {
    PrimaryCustomElevatedButton(
        backgroundColor = primaryColor,
        buttonTitle = "Continue",
        titleColor = Color.White,
        onClick = {}
    )
}








