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
import coil.compose.AsyncImage
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
internal fun CoinLogo(image: String?) {
    Box(contentAlignment = Alignment.Center) {
        AsyncImage(
            modifier = Modifier.size(40.dp),
            model = image,
            contentDescription = "coin_image",
        )
    }
}

@Composable
internal fun CoinLogoBig(image: String?) {
    Box(contentAlignment = Alignment.Center) {
        AsyncImage(
            modifier = Modifier.size(90.dp),
            model = image,
            contentDescription = "coin_image_big",
        )
    }
}