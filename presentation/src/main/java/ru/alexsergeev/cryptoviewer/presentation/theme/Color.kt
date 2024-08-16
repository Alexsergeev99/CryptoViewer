package ru.alexsergeev.cryptoviewer.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class Colors(
    val activeBackground: Color,
    val activeComponent: Color,
    val subheadingText: Color,
    val goodNewsColor: Color,
    val bitcoinLogoColor: Color
)

val ColorInstance = Colors(
    activeBackground = Color(0xFFF1ECDA),
    activeComponent = Color(0xFFFFAD25),
    subheadingText = Color(0xFF9B9B9B),
    goodNewsColor = Color(0xFF2A9D8F),
    bitcoinLogoColor = Color(0xFFF7931A)
)

val LocalColors = staticCompositionLocalOf { ColorInstance }
