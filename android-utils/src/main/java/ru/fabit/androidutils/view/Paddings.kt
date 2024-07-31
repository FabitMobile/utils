package ru.fabit.androidutils.view

import android.view.View

class Paddings() : Indent {
    @Dp
    override var left: Int = 0

    @Dp
    override var top: Int = 0

    @Dp
    override var right: Int = 0

    @Dp
    override var bottom: Int = 0

    constructor(@Dp padding: Int) : this() {
        left = padding
        top = padding
        right = padding
        bottom = padding
    }

    constructor(
        @Dp left: Int = 0,
        @Dp top: Int = 0,
        @Dp right: Int = 0,
        @Dp bottom: Int = 0
    ) : this() {
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }

    constructor(
        @Dp horizontal: Int = 0,
        @Dp vertical: Int = 0
    ) : this() {
        this.left = horizontal
        this.top = vertical
        this.right = horizontal
        this.bottom = vertical
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Paddings
        if (left != other.left) return false
        if (top != other.top) return false
        if (right != other.right) return false
        if (bottom != other.bottom) return false
        return true
    }

    override fun hashCode(): Int {
        var result = left
        result = 31 * result + top
        result = 31 * result + right
        result = 31 * result + bottom
        return result
    }
}

fun View.setPaddings(paddings: Paddings) {
    val left = dpToPx(context, paddings.left.toFloat())
    val top = dpToPx(context, paddings.top.toFloat())
    val right = dpToPx(context, paddings.right.toFloat())
    val bottom = dpToPx(context, paddings.bottom.toFloat())
    setPadding(left, top, right, bottom)
}
