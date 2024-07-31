package ru.fabit.androidutils.view

import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.DimenRes
import androidx.annotation.Px

fun Context.getDensity() = resources.displayMetrics.density

@Px
fun Context.getDimensionInPx(@DimenRes dimenResId: Int) =
    resources.getDimensionPixelSize(dimenResId)

@Px
fun Context.getDisplayHeightInPx() = resources.displayMetrics.heightPixels

@Px
fun Context.getDisplayWidthInPx() = resources.displayMetrics.widthPixels

@Px
inline fun dpToPx(context: Context, @Dp dp: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dp,
    context.resources.displayMetrics
).toInt()

@Px
inline fun spToPx(context: Context, @Sp sp: Float) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    sp,
    context.resources.displayMetrics
).toInt()

inline fun Context.measure(block: MeasureScope.() -> Int): Int {
    return block(MeasureScope(this))
}

inline fun View.measure(block: MeasureScope.() -> Int): Int {
    return block(MeasureScope(this.context))
}

@JvmInline
value class MeasureScope(val context: Context) {
    inline val Int.dp: Int
        get() = dpToPx(context, this.toFloat())

    inline val Int.sp: Int
        get() = spToPx(context, this.toFloat())
}