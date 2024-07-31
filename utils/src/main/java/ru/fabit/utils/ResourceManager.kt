package ru.fabit.utils

interface ResourceManager {
    fun getBoolean (resId: Int): Boolean

    fun getString(resId: Int): String

    fun getString(resId: Int, vararg formatArgs: Any?): String

    fun getDimen(resId: Int): Float

    fun getQuantityString(resId: Int, quantity: Int): String

    fun getColor(resId: Int): Int

    fun getStringArray(resId: Int): Array<String>

    fun getColorIntByAttribute(attResId: Int): Int

    fun getColorResByAttribute(attrResId: Int): Int
}
