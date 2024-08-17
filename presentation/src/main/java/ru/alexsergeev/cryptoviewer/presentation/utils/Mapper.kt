package ru.alexsergeev.cryptoviewer.presentation.utils

interface Mapper<in I, out O> {
    fun map(input: I): O
}