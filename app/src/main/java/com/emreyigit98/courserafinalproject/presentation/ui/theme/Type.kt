package com.emreyigit98.courserafinalproject.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.emreyigit98.courserafinalproject.R

val font = FontFamily(
    Font(R.font.markazitext_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontSize = 11.sp,
        fontFamily = font
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = font
    ),
    bodyLarge = TextStyle(
        fontSize = 22.sp,
        fontFamily = font
    )
)
