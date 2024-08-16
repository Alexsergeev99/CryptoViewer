package ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
fun AdaLogo() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            painterResource(id = R.drawable.ada_base),
            "ada_base",
            tint = CryptoTheme.colors.adaLogoColor
        )
        Icon(
            painterResource(id = R.drawable.ada_logo),
            "ada_logo",
            tint = Color.White
        )
    }
}