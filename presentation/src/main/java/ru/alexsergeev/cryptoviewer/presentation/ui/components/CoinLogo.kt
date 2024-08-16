package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.alexsergeev.cryptoviewer.presentation.R

@Composable
fun CoinLogo(image: String) {
    AsyncImage(
        modifier = Modifier
            .size(40.dp),
        model = image,
        contentDescription = "coin_logo",
    )
}