package ru.fabit.androidutils.view

sealed interface Indent {
    @Dp
    var left: Int

    @Dp
    var top: Int

    @Dp
    var right: Int

    @Dp
    var bottom: Int
}