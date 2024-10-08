package ru.alexsergeev.cryptoviewer.data.utils

interface Mapper<in I, out O> {
    fun map(input: I): O
}