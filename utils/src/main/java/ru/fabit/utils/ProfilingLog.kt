package ru.fabit.utils

import kotlin.Pair

class ProfilingLog private constructor(private val printer: (String) -> Unit) {

    companion object {
        @JvmStatic
        lateinit var instance: ProfilingLog
            private set

        @JvmStatic
        fun init(enableLogger: Boolean, printer: (String) -> Unit) {
            instance =
                ProfilingLog(printer)
            instance.enabled = enableLogger
        }

    }

    private var enabled = false

    private val trackers =
        java.util.Collections.synchronizedMap(LinkedHashMap<String, Pair<String, String>>())

    fun tracking(name: String, time: Long, log: String = "") {
        takeUnless { enabled }
            ?: trackers[name]?.let {
                val oldTime = tryToLong(it.first)

                trackers.put(name, Pair((oldTime + time).toString(), getLog(log, it.second)))
            }
            ?: trackers.put(name, Pair("", log))
    }

    private fun tryToLong(time: String): Long {
        return try {
            time.toLong()
        } catch (e: Exception) {
            0L
        }
    }

    private fun getLog(log: String, oldLog: String): String {
        return if (log.isNotEmpty()) {
            if (oldLog.isNotEmpty()) {
                "$oldLog\n$log"
            } else log
        } else oldLog
    }

    fun tracking(name: String, log: String) {
        takeUnless { enabled }
            ?: trackers[name]?.let {
                trackers.put(name, Pair(it.first, getLog(log, it.second)))
            }
            ?: trackers.put(name, Pair("", log))
    }

    fun printAll() {
        takeUnless { enabled } ?: trackers.forEach {
            val time = getTimeForPrint(it.value.first)
            printer("${it.key} -> $time ${it.value.second}")
        }
    }

    private fun getTimeForPrint(rawTime: String) =
        if (rawTime.isNotEmpty()) "$rawTime ms" else rawTime

    private fun getTracker(name: String): String {
        return trackers[name]?.let { "$name -> ${getTimeForPrint(it.first)} ${it.second}" }
            ?: "$name is not found"
    }

    fun printTracker(name: String) {
        takeUnless { enabled } ?: printer(getTracker(name))
    }

    fun clearAll() {
        takeUnless { enabled } ?: trackers.clear()
    }

    fun clearTracker(name: String) {
        takeUnless { enabled } ?: trackers.remove(name)
    }
}