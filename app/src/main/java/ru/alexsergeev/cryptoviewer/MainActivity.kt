package ru.alexsergeev.cryptoviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexsergeev.cryptoviewer.presentation.ui.screens.CoinDetailScreenDemo
import ru.alexsergeev.cryptoviewer.presentation.ui.screens.MainScreenDemo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            MainScreenDemo()
            CoinDetailScreenDemo()
        }
    }
}