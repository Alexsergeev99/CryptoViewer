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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.CoinLogo
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel

@Composable
internal fun CryptoCoinItem(
    coin: CoinUiModel,
    viewModel: MainScreenViewModel = koinViewModel(),
    goToCoinDetailScreen: () -> Unit = {}
) {

    val showInDollars = viewModel.showInDollars().collectAsStateWithLifecycle().value

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                goToCoinDetailScreen()
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
                CoinLogo(coin.image)
                Column(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = coin.name,
                        color = Color.Black,
                        style = CryptoTheme.typography.heading2
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = coin.symbol,
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
                    text = if(showInDollars) "$ ${coin.price}" else "$ ${coin.price}", //временное решение
                    color = Color.Black,
                    style = CryptoTheme.typography.heading2
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "${coin.priceChangePercentage24h}%",
                    color = if (coin.priceChangePercentage24h.startsWith("-")) {
                        CryptoTheme.colors.badNewsColor
                    } else {
                        CryptoTheme.colors.goodNewsColor
                    },
                    style = CryptoTheme.typography.heading2,
                )
            }
        }
    }
}