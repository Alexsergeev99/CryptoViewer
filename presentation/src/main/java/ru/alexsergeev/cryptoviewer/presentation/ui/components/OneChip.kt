package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
internal fun OneChip(text: String, showInDollars: Boolean = true) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = 2.dp, vertical = 1.dp)
            .height(32.dp)
            .width(90.dp)
            .background(
                color = if (showInDollars) CryptoTheme.colors.activeBackground else Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            text = text,
            color = if (showInDollars) CryptoTheme.colors.activeComponent else Color.Black,
            style = CryptoTheme.typography.metadata1
        )
    }
}