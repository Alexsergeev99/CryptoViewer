package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.TryElseButton
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BitcoinLogoError

@Composable
internal fun ErrorScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BitcoinLogoError()
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.something_went_wrong),
            color = Color.Black,
            style = CryptoTheme.typography.heading2,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = stringResource(id = R.string.will_try_again),
            color = Color.Black,
            style = CryptoTheme.typography.heading2,
            textAlign = TextAlign.Center,
        )
        TryElseButton(text = stringResource(id = R.string.try_else)) {
            onClick()
        }
    }
}