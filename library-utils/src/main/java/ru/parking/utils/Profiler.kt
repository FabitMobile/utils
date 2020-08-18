package ru.parking.utils

import java.util.concurrent.atomic.AtomicLong

class Profiler(private val printResult: (string: String) -> Unit) {

    private val time: AtomicLong = AtomicLong()

    fun <T> analysis(code: () -> T): T {
        val start = System.currentTimeMillis()
        val result: T = code()
        time.addAndGet(System.currentTimeMillis() - start)
        return result
    }

    fun analysis(code: () -> Unit) {
        val start = System.currentTimeMillis()
        code()
        time.addAndGet(System.currentTimeMillis() - start)
    }

    fun print() {
        printResult("${time.get()} ms")
    }
}