package ru.fabit.utils

import kotlin.math.abs

class ClickManager(private val sampleStepMillis: Long = 500) {

    private var lastCheck = 0L

    fun isApproved(body: () -> Unit) {
        if (abs(System.currentTimeMillis() - lastCheck) > sampleStepMillis) {
            lastCheck = System.currentTimeMillis()
            body.invoke()
        }
    }
}