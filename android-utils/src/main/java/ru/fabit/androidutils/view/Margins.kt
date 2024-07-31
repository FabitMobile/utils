package ru.fabit.androidutils.view

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.view.updateLayoutParams

class Margins() : Indent {
    @Dp
    override var left: Int = 0

    @Dp
    override var top: Int = 0

    @Dp
    override var right: Int = 0

    @Dp
    override var bottom: Int = 0

    constructor(@Dp margin: Int) : this() {
        left = margin
        top = margin
        right = margin
        bottom = margin
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

        other as Margins

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

fun View.setMargins(
    margins: Margins,
    update: (ViewGroup.LayoutParams.(left: Int, top: Int, right: Int, bottom: Int) -> Unit)? = null
) {
    val left = dpToPx(context, margins.left.toFloat())
    val top = dpToPx(context, margins.top.toFloat())
    val right = dpToPx(context, margins.right.toFloat())
    val bottom = dpToPx(context, margins.bottom.toFloat())
    updateLayoutParams {
        when (this) {
            is LinearLayout.LayoutParams -> {
                setMargins(left, top, right, bottom)
            }

            is RelativeLayout.LayoutParams -> {
                setMargins(left, top, right, bottom)
            }

            is FrameLayout.LayoutParams -> {
                setMargins(left, top, right, bottom)
            }

            else -> update?.invoke(this, left, top, right, bottom)
        }
    }
}