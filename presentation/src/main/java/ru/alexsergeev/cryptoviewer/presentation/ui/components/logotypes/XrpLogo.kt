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
fun XrpLogo() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            painterResource(id = R.drawable.xrp_base),
            "xrp_base",
            tint = CryptoTheme.colors.xrpLogoColor
        )
        Icon(
            painterResource(id = R.drawable.xrp_logo),
            "xrp_logo",
            tint = Color.White
        )
    }
}