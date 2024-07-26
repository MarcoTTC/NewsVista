package br.com.marcottc.newsvista.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Typography based on Fortnightly style, using Merriweather and LibreFranklin fonts
val NewsVistaTypography = Typography(
        displayLarge = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                lineHeight = 64.sp,
                letterSpacing = (-0.25).sp,
                fontSize = 96.sp
        ),
        displayMedium = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Normal,
                lineHeight = 52.sp,
                letterSpacing = 0.sp,
                fontSize = 60.sp
        ),
        displaySmall = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                lineHeight = 44.sp,
                letterSpacing = 0.sp,
                fontSize = 48.sp
        ),
        headlineMedium = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
                fontSize = 34.sp
        ),
        headlineSmall = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
                fontSize = 24.sp
        ),
        titleLarge = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
                fontSize = 20.sp
        ),
        titleMedium = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                lineHeight = 24.sp,
                letterSpacing = (0.15).sp,
                fontSize = 16.sp
        ),
        titleSmall = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
                fontSize = 14.sp
        ),
        bodyLarge = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                lineHeight = 24.sp,
                letterSpacing = (0.5).sp,
                fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                lineHeight = 20.sp,
                letterSpacing = (0.25).sp,
                fontSize = 14.sp
        ),
        bodySmall = TextStyle(
                fontFamily = Merriweather,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                lineHeight = 16.sp,
                letterSpacing = (0.4).sp,
                fontSize = 12.sp
        ),
        labelLarge = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                lineHeight = 20.sp,
                letterSpacing = (0.1).sp,
                fontSize = 14.sp
        ),
        labelSmall = TextStyle(
                fontFamily = LibreFranklin,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                lineHeight = 16.sp,
                letterSpacing = (0.5).sp,
                fontSize = 10.sp
        )
)