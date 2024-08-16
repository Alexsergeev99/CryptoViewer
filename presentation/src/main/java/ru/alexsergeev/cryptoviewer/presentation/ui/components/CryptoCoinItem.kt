package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.AdaLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.AtomLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BinanceLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BitcoinLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.EthLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.XrpLogo

@Composable
fun CryptoCoinItem(title: String, ticker: String, price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {

            },
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 1.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                when (ticker) {
                    "BTC" -> BitcoinLogo()
                    "ETH" -> EthLogo()
                    "ADA" -> AdaLogo()
                    "ATOM" -> AtomLogo()
                    "BNB" -> BinanceLogo()
                    else -> XrpLogo()
                }
                Column(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = title,
                        color = Color.Black,
                        style = CryptoTheme.typography.heading2
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = ticker,
                        color = CryptoTheme.colors.subheadingText,
                        style = CryptoTheme.typography.heading2
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = price,
                    color = Color.Black,
                    style = CryptoTheme.typography.heading2
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "+ 4.05%",
                    color = CryptoTheme.colors.goodNewsColor,
                    style = CryptoTheme.typography.heading2,
                )
            }
        }
    }
}