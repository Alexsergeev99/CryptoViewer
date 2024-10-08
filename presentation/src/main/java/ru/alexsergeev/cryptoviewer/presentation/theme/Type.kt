package ru.alexsergeev.cryptoviewer.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import ru.alexsergeev.cryptoviewer.presentation.R

val robotoFontFamily = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_medium, FontWeight.SemiBold),
    Font(R.font.roboto_regular, FontWeight.Normal),
)

@Immutable
data class Typography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val metadata1: TextStyle
)

val lineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

val TypographyInstance = Typography(
    heading1 = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),
    heading2 = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading1 = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 14.sp,
        lineHeight = 16.sp,
        lineHeightStyle = lineHeightStyle
    ),
    subheading2 = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(500),
        fontSize = 20.sp,
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),
    metadata1 = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 14.sp,
        lineHeight = 20.sp,
        lineHeightStyle = lineHeightStyle
    ),
)

val LocalTypography = staticCompositionLocalOf { TypographyInstance }