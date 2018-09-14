package io.github.vicfran.lib

sealed class Either<out L, out R> {

    data class Left<out T>(val value: T) : Either<T, Nothing>() {
        override fun isRight() = false
        override fun isLeft() = true
    }

    data class Right<out T>(val value: T) : Either<Nothing, T>() {
        override fun isRight() = true
        override fun isLeft() = false
    }

    abstract fun isRight(): Boolean
    abstract fun isLeft(): Boolean

    inline fun <C> fold(left: (L) -> C, right: (R) -> C): C = when (this) {
        is Left -> left(value)
        is Right -> right(value)
    }

    inline fun <C> map(f: (R) -> C): Either<L, C> = fold({ Left(it) }, { Right(f(it))})

}