package ru.fabit.androidutils.span

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.text.inSpans

inline fun SpannableStringBuilder.clickable(
    crossinline onClick: () -> Unit,
    isUnderlineText: Boolean = false,
    @ColorInt linkColor: Int? = null,
    builderAction: SpannableStringBuilder.() -> Unit
): SpannableStringBuilder = inSpans(object : ClickableSpan() {
    override fun onClick(widget: View) {
        onClick()
    }

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.color = linkColor ?: ds.linkColor
        ds.isUnderlineText = isUnderlineText
    }
}, builderAction = builderAction)

fun SpannableStringBuilder.underlined(text: CharSequence) {
    val startIndex = length
    append(text)
    setSpan(
        UnderlineSpan(),
        startIndex,
        length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
}