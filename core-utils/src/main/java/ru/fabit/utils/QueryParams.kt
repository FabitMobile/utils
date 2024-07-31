package ru.fabit.utils

class QueryParams private constructor() {

    companion object {
        @JvmStatic
        fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {

        private val query: MutableMap<String, String> = mutableMapOf()

        infix fun String.to(param: Any) {
            query[this] = param.toString()
        }

        operator fun Pair<String, Any>.unaryPlus() {
            query[first] = second.toString()
        }

        operator fun set(key: String, value: Any) {
            query[key] = value.toString()
        }

        fun addQueryParam(key: String, value: String): Builder {
            query[key] = value
            return this
        }

        fun addQueryParam(key: String, value: Int): Builder {
            query[key] = value.toString()
            return this
        }

        fun addQueryParamWithCondition(
            key: String,
            value: String,
            condition: () -> Boolean
        ): Builder {
            if (condition()) {
                query[key] = value
            }
            return this
        }

        fun addQueryParamWithCondition(key: String, value: Int, condition: () -> Boolean): Builder {
            if (condition()) {
                query[key] = value.toString()
            }
            return this
        }

        fun build(): String {
            var queryParams = ""
            val keys = query.keys.sorted()
            keys.forEach { key ->
                val value = query.getValue(key)
                queryParams = queryParams.addQueryParam(key, value)
            }
            return queryParams
        }
    }
}

fun String.addQueryParam(key: String, value: Any): String {
    return if (this.isEmpty()) "?$key=$value" else "$this&$key=$value"
}