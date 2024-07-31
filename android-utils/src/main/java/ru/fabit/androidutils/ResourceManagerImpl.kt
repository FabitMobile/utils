package ru.fabit.androidutils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import androidx.annotation.ArrayRes
import androidx.annotation.AttrRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import ru.fabit.utils.ResourceManager

class ResourceManagerImpl(
    private val context: Context,
    private val theme: Resources.Theme
) : ResourceManager {

    override fun getBoolean(@BoolRes resId: Int) = context.resources.getBoolean(resId)

    override fun getString(@StringRes resId: Int) = context.getString(resId)

    override fun getString(@StringRes resId: Int, vararg formatArgs: Any?) =
        context.getString(resId, *formatArgs)

    override fun getDimen(@DimenRes resId: Int) = context.resources.getDimension(resId)

    override fun getQuantityString(@PluralsRes resId: Int, quantity: Int) =
        context.resources.getQuantityString(resId, quantity)

    override fun getColor(@ColorRes resId: Int) = ContextCompat.getColor(context, resId)

    override fun getStringArray(@ArrayRes resId: Int): Array<String> =
        context.resources.getStringArray(resId)

    @ColorInt
    override fun getColorIntByAttribute(@AttrRes attResId: Int): Int {
        val typedValue = TypedValue()
        theme.resolveAttribute(attResId, typedValue, true)
        return typedValue.data
    }

    @ColorRes
    override fun getColorResByAttribute(@AttrRes attrResId: Int): Int {
        val typedValue = TypedValue()
        theme.resolveAttribute(attrResId, typedValue, true)
        return typedValue.resourceId
    }
}

val Context.asResourceManager: ResourceManager
    get() = ResourceManagerImpl(this, theme)
