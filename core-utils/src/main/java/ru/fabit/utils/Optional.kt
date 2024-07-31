package ru.fabit.utils

interface Optional<T> {

    fun isNull(): Boolean

    fun isNotNull(): Boolean

    fun getValue(): T

    fun orNull(): T?

    fun orElse(default: T): T

    companion object {
        @JvmStatic
        operator fun <T> invoke(nullable: T? = null): Optional<T> = OptionalImpl(nullable)

        @JvmStatic
        fun <T> from(nullable: T? = null): Optional<T> = OptionalImpl(nullable)

        @JvmStatic
        val EMPTY = Optional(null)

        @JvmStatic
        @Suppress("UNCHECKED_CAST")
        fun <T> createEmpty(): Optional<T> = EMPTY as Optional<T>
    }
}

val <T> Optional<T>.value: T
    get() = getValue()

val <T> Optional<T>.isNull: Boolean
    get() = isNull()

val <T> Optional<T>.isNotNull: Boolean
    get() = isNotNull()

val <T> Optional<T>.orNull: T?
    get() = orNull()

@JvmInline
value class OptionalImpl<T>(
    private val nullable: T? = null
) : Optional<T> {

    override fun isNull(): Boolean = nullable == null

    override fun isNotNull(): Boolean = nullable != null

    override fun getValue(): T =
        nullable ?: throw NoSuchElementException("No value present in this Optional")

    override fun orNull(): T? = nullable

    override fun orElse(default: T): T = nullable ?: default
}