package ru.fabit.utils

import java.util.*

object Collections {

    fun <T> areEqualIgnoringOrder(
        list1: List<T>,
        list2: List<T>,
        comparator: Comparator<in T>
    ): Boolean {

        // if not the same size, lists are not equal
        if (list1.size != list2.size) {
            return false
        }

        // create sorted copies to avoid modifying the original lists
        val copy1 = ArrayList(list1)
        val copy2 = ArrayList(list2)

        java.util.Collections.sort(copy1, comparator)
        java.util.Collections.sort(copy2, comparator)

        // iterate through the elements and compare them one by one using
        // the provided comparator.
        val it1 = copy1.iterator()
        val it2 = copy2.iterator()
        while (it1.hasNext()) {
            val t1 = it1.next()
            val t2 = it2.next()
            if (comparator.compare(t1, t2) != 0) {
                // as soon as a difference is found, stop looping
                return false
            }
        }
        return true
    }
}
