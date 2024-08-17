package ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
internal fun BitcoinLogo() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            painterResource(id = R.drawable.btc_base),
            "btc_base",
            tint = CryptoTheme.colors.bitcoinLogoColor
        )
        Icon(
            painterResource(id = R.drawable.btc_logo),
            "btc_logo",
            tint = Color.White
        )
    }
}

@Composable
internal fun BitcoinLogoBig() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier.size(90.dp),
            painter = painterResource(id = R.drawable.btc_base),
            contentDescription = "btc_base",
            tint = CryptoTheme.colors.bitcoinLogoColor
        )
        Icon(
            modifier = Modifier.height(56.dp).width(42.dp),
            painter = painterResource(id = R.drawable.btc_logo),
            contentDescription = "btc_logo",
            tint = Color.White
        )
    }
}