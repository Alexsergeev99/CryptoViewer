package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
fun CryptoTopBar(text: String) {
    Column(
        modifier = Modifier
            .height(118.dp)
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = text,
            color = Color.Black,
            style = CryptoTheme.typography.heading1
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OneChip("USD")
            OneChip("RUB",false)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNew() {
    TopAppBar(title = { /*TODO*/ })
}