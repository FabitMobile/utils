package ru.fabit.utils

import java.util.TimeZone

interface TimeSource {
    val currentSystemTime: Long

    val timezone: String
        get() = TimeZone.getDefault().toString()

    companion object default : TimeSource {
        override val currentSystemTime: Long
            get() = System.currentTimeMillis()
    }
}