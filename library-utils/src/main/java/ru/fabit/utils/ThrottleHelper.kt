package ru.fabit.utils

import kotlin.math.abs

class ThrottleHelper(private val sampleStepMillis: Long = 500) {

    private var lastCheck = 0L

    fun isApproved(body: () -> Unit) {
        if (abs(System.currentTimeMillis() - lastCheck) > sampleStepMillis) {
            lastCheck = System.currentTimeMillis()
            body.invoke()
        }
    }
}