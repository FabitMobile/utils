package ru.fabit.utils

interface TimeSource {
    val currentSystemTime: Long

    companion object default : TimeSource {
        override val currentSystemTime: Long
            get() = System.currentTimeMillis()
    }
}