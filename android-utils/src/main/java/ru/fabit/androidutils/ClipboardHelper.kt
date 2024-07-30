package ru.fabit.androidutils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Handler
import android.os.Looper

class ClipboardHelper(private val context: Context) {
    fun copyToClipboard(text: String) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            copy(text)
        } else {
            Handler(Looper.getMainLooper()).post {
                copy(text)
            }
        }
    }

    private fun copy(text: String) {
        val clipboard =
            context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
        val clip = ClipData.newPlainText("", text)
        clipboard?.setPrimaryClip(clip)
    }
}

fun Context.copyToClipboard(text: String) = ClipboardHelper(this).copyToClipboard(text)