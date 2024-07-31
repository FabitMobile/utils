package ru.fabit.utils

sealed class Either<out A, out B> {

    data class Left<out A>(val a: A) : Either<A, Nothing>()

    data class Right<out B>(val b: B) : Either<Nothing, B>()

    val isLeft: Boolean
        get() = this is Left<A>

    val isRight: Boolean
        get() = this is Right<B>

    fun getLeft() = (this as Left<A>).a

    fun getRight() = (this as Right<B>).b

    override fun equals(other: Any?): Boolean {
        if (other !is Either<*, *>)
            return false

        return if (isLeft && other.isLeft) {
            getLeft() == other.getLeft()
        } else if (isRight && other.isRight) {
            getRight() == other.getRight()
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return if (isLeft)
            getLeft().hashCode()
        else
            getRight().hashCode()
    }

    companion object {
        @JvmStatic
        fun <A> left(left: A) = Left(left)

        @JvmStatic
        fun <B> right(right: B) = Right(right)
    }

    fun either(ifLeft: (A) -> Any, ifRight: (B) -> Any): Any =
        when (this) {
            is Left -> ifLeft(a)
            is Right -> ifRight(b)
        }
}

