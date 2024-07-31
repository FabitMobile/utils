package ru.fabit.androidutils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

fun awaitDebug(timeMillis: Long = 60_000) {
    runBlocking {
        awaitAll(CoroutineScope(Dispatchers.IO).async {
            Thread.sleep(timeMillis)
        })
    }
}