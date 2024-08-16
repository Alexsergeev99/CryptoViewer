package ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
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
internal fun XrpLogo() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.xrp_base),
            contentDescription = "xrp_base",
            tint = CryptoTheme.colors.xrpLogoColor
        )
        Icon(
            painterResource(id = R.drawable.xrp_logo),
            "xrp_logo",
            tint = Color.White
        )
    }
}

@Composable
internal fun XrpLogoBig() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier.size(90.dp),
            painter = painterResource(id = R.drawable.xrp_base),
            contentDescription = "xrp_base",
            tint = CryptoTheme.colors.xrpLogoColor
        )
        Icon(
            painterResource(id = R.drawable.xrp_logo),
            "xrp_logo",
            tint = Color.White
        )
    }
}