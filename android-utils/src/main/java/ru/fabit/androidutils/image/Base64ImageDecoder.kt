package ru.fabit.androidutils.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

object Base64ImageDecoder {
    fun toBitmap(input: String): Bitmap {
        val decodedString: ByteArray = Base64.decode(input, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    }
}