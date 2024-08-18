package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.utils.NoRippleTheme
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel

@Composable
internal fun OneChipUSD(text: String, viewModel: MainScreenViewModel = koinViewModel()) {

    val showInDollars = viewModel.showInDollars().collectAsStateWithLifecycle().value
    val interactionSource = remember {
        MutableInteractionSource()
    }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
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
                .clip(RoundedCornerShape(20.dp))
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    viewModel.changeChipState()
                }
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = text,
                color = if (showInDollars) CryptoTheme.colors.activeComponent else Color.Black,
                style = CryptoTheme.typography.metadata1
            )
        }
    }
}

@Composable
internal fun OneChipRUB(text: String, viewModel: MainScreenViewModel = koinViewModel()) {

    val showInRubles = viewModel.showInRubles().collectAsStateWithLifecycle().value
    val interactionSource = remember {
        MutableInteractionSource()
    }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 1.dp)
                .height(32.dp)
                .width(90.dp)
                .background(
                    color = if (showInRubles) CryptoTheme.colors.activeBackground else Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    viewModel.changeChipState()
                },
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = text,
                color = if (showInRubles) CryptoTheme.colors.activeComponent else Color.Black,
                style = CryptoTheme.typography.metadata1
            )
        }
    }
}