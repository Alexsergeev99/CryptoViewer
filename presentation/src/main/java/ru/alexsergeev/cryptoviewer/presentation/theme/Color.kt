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
    val badNewsColor: Color,
    val bitcoinLogoColor: Color,
    val ethLogoColor: Color,
    val adaLogoColor: Color,
    val atomLogoColor: Color,
    val xrpLogoColor: Color,
    val binanceLogoColor: Color
)

val ColorInstance = Colors(
    activeBackground = Color(0xFFF1ECDA),
    activeComponent = Color(0xFFFFAD25),
    subheadingText = Color(0xFF9B9B9B),
    goodNewsColor = Color(0xFF2A9D8F),
    badNewsColor = Color(0xFFEB5757),
    bitcoinLogoColor = Color(0xFFF7931A),
    ethLogoColor = Color(0xFF627EEA),
    adaLogoColor = Color(0xFF0D1E30),
    atomLogoColor = Color(0xFF2E3148),
    xrpLogoColor = Color(0xFF23292F),
    binanceLogoColor = Color(0xFFF3BA2F),
)

val LocalColors = staticCompositionLocalOf { ColorInstance }
