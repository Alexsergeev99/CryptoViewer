package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
internal fun CryptoTopBar(text: String) {
    Column(
        modifier = Modifier
            .height(118.dp)
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.alpha(0.87f),
            text = text,
            color = Color.Black,
            style = CryptoTheme.typography.subheading2
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OneChipUSD("USD")
            OneChipRUB("RUB")
        }
    }
}

@Composable
internal fun CryptoTopBarMini(text: String, goToBackScreen: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(end = 24.dp)
                .clickable {
                           goToBackScreen()
                },
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = "back_button"
        )
        Text(
            modifier = Modifier.alpha(0.87f),
            text = text,
            color = Color.Black,
            style = CryptoTheme.typography.subheading2
        )
    }
}