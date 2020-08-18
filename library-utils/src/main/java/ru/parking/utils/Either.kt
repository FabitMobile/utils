package ru.parking.utils

sealed class Either<out A, out B> {

    data class Left<out A>(val a: A) : Either<A, Nothing>()

    data class Right<out B>(val b: B) : Either<Nothing, B>()

    fun isLeft() = this is Left<A>

    fun isRight() = this is Right<B>

    fun getLeft() = (this as Left<A>).a

    fun getRight() = (this as Right<B>).b

    companion object {
        @JvmStatic
        fun <A> left(left: A) = Left(left)

        @JvmStatic
        fun <B> right(right: B) = Right(right)
    }

    fun either(funcA: (A) -> Any, funcB: (B) -> Any): Any =
        when (this) {
            is Left -> funcA(a)
            is Right -> funcB(b)
        }

}

