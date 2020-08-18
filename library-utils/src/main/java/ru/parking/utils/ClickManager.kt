package ru.parking.utils

class ClickManager(private val sampleStepMillis: Long = 500) {

    private var lastCheck = 0L

    fun isApproved(body: () -> Unit) {
        if (System.currentTimeMillis() > lastCheck + sampleStepMillis) {
            lastCheck = System.currentTimeMillis()
            body.invoke()
        }
    }
}