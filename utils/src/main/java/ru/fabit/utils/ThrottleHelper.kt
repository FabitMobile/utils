package ru.fabit.utils

import kotlin.math.abs

class ThrottleHelper(
    private val sampleStepMillis: Long = 500,
    private val timeSource: TimeSource = TimeSource.default
) {

    private var lastCheck = 0L

    fun isApproved(body: () -> Unit) {
        if (abs(timeSource.currentSystemTime - lastCheck) > sampleStepMillis) {
            lastCheck = timeSource.currentSystemTime
            body.invoke()
        }
    }
}