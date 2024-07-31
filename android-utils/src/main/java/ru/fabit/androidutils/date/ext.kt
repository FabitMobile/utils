@file:JvmName("FormatterDateTime")
@file:JvmMultifileClass

package ru.fabit.androidutils.date

import org.joda.time.DateTime
import org.joda.time.LocalDate
import ru.fabit.utils.TimeSource
import java.util.Date

fun DateTime.plusDay(): DateTime = plusDays(1)

fun DateTime.minusDay(): DateTime = minusDays(1)

fun LocalDate.plusDay(): LocalDate = plusDays(1)

fun LocalDate.minusDay(): LocalDate = minusDays(1)

fun Date.toDateTime(): DateTime = DateTime(this)

fun Date.formatWith(pattern: DateTime.() -> Function0<String>): String =
    DateTime(this).let { pattern(it).invoke() }

fun Date.format(pattern: Function1<DateTime, String>): String = pattern(DateTime(this))

fun DateTime.isBefore(timeSource: TimeSource): Boolean {
    val currentDateTime = DateTime(timeSource.currentSystemTime)
    return currentDateTime.isBefore(this)
}

fun DateTime.isToday(timeSource: TimeSource): Boolean {
    val localDateTime = LocalDate(timeSource.currentSystemTime)
    return localDateTime == LocalDate(this)
}

fun DateTime.isTomorrow(timeSource: TimeSource): Boolean {
    val localDateTime = LocalDate(timeSource.currentSystemTime)
    return localDateTime.plusDay() == LocalDate(this)
}

fun DateTime.isYesterday(timeSource: TimeSource): Boolean {
    val localDateTime = LocalDate(timeSource.currentSystemTime)
    return localDateTime.minusDay() == LocalDate(this)
}

fun DateTime.inTheSameDay(dateTime: DateTime): Boolean {
    val inTheSameYear = year().get() == dateTime.year().get()
    return inTheSameYear && dayOfYear().get() == dateTime.dayOfYear().get()
}