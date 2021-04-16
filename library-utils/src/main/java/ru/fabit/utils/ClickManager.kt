package ru.fabit.utils

class ClickManager(private val sampleStepMillis: Long = 500, private val timeSource: TimeSource) {

    private var lastCheck = 0L

    fun isApproved(body: () -> Unit) {
        if (timeSource.currentSystemTime() > lastCheck + sampleStepMillis) {
            lastCheck = timeSource.currentSystemTime()
            body.invoke()
        }
    }
}