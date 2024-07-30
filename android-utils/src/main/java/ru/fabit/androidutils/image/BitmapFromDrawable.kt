package ru.fabit.androidutils.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

class BitmapFromDrawable(
    private val context: Context,
    @DrawableRes private val id: Int
) {
    private var w: Int? = null
    private var h: Int? = null
    private var color: Int? = null

    fun size(w: Int, h: Int): BitmapFromDrawable {
        this.w = w
        this.h = h
        return this
    }

    /**
     * apply SRC_IN colorFilter
     * @see android.graphics.PorterDuff.Mode
     */
    fun color(color: Int): BitmapFromDrawable {
        this.color = color
        return this
    }

    fun get(): Bitmap {
        val drawable = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            ContextCompat.getDrawable(context, id)
        } else {
            VectorDrawableCompat.create(context.resources, id, context.theme)
        }
        val bitmap = Bitmap.createBitmap(
            w ?: drawable?.intrinsicWidth ?: 0,
            h ?: drawable?.intrinsicHeight ?: 0,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        color?.let {
            drawable?.colorFilter = PorterDuffColorFilter(it, PorterDuff.Mode.SRC_IN)
        }
        drawable?.setBounds(0, 0, canvas.width, canvas.height)
        drawable?.draw(canvas)
        return bitmap
    }
}