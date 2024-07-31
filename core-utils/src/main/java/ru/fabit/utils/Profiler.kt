package ru.fabit.utils

import java.util.concurrent.atomic.AtomicLong

class Profiler(
    private val printResult: (string: String) -> Unit,
    private val timeSource: TimeSource = TimeSource.default
) {

    private val time: AtomicLong = AtomicLong()

    fun <T> analysis(code: () -> T): T {
        val start = timeSource.currentSystemTime
        val result: T = code()
        time.addAndGet(timeSource.currentSystemTime - start)
        return result
    }

    fun analysis(code: () -> Unit) {
        val start = timeSource.currentSystemTime
        code()
        time.addAndGet(timeSource.currentSystemTime - start)
    }

    fun print() {
        printResult("${time.get()} ms")
    }
}