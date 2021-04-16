package ru.fabit.utils

interface TimeSource {

    fun currentSystemTime(): Long
}