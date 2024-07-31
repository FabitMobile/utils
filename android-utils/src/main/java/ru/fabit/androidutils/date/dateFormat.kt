@file:JvmName("FormatterDateTime")
@file:JvmMultifileClass

package ru.fabit.androidutils.date

import org.joda.time.DateTime
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT_WITH_COMMA
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT_WITH_POINT
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT_WITH_COMMA
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT_WITH_POINT
import ru.fabit.utils.DATE_DAY_SHORT_MONTH_MEDIUM
import ru.fabit.utils.DATE_DEFAULT
import ru.fabit.utils.DATE_DEFAULT_DAY_SEPARATE
import ru.fabit.utils.DATE_DEFAULT_DAY_SEPARATE_SHORT_DAY
import ru.fabit.utils.DATE_DEFAULT_SHORT_DAY
import ru.fabit.utils.DATE_MEDIUM
import ru.fabit.utils.DATE_MEDIUM_TIME_DEFAULT
import ru.fabit.utils.DATE_MEDIUM_TIME_DEFAULT_WITH_COMMA
import ru.fabit.utils.DATE_MEDIUM_TIME_DEFAULT_WITH_COMMA_SPLIT
import ru.fabit.utils.DATE_MEDIUM_TIME_DEFAULT_WITH_POINT
import ru.fabit.utils.DATE_SHORT
import ru.fabit.utils.DATE_SHORT_TIME_SHORT
import ru.fabit.utils.DATE_SHORT_TIME_SHORT_WITH_COMMA
import ru.fabit.utils.DATE_SHORT_TIME_SHORT_WITH_POINT
import ru.fabit.utils.DATE_SHORT_WITH_SHORT_YEAR
import ru.fabit.utils.DATE_SHORT_WITH_SHORT_YEAR_TIME_DEFAULT
import ru.fabit.utils.DATE_TIME_DEFAULT
import ru.fabit.utils.DATE_TIME_DEFAULT_SHORT_DAY
import ru.fabit.utils.DATE_TIME_ISO
import ru.fabit.utils.DATE_TIME_ISO_AND_MILLIS
import ru.fabit.utils.DATE_TIME_ISO_AND_MILLIS_AND_TZ
import ru.fabit.utils.DATE_WITH_SHORT_YEAR
import ru.fabit.utils.DATE_WITH_SHORT_YEAR_TIME_DEFAULT
import ru.fabit.utils.FULL_DATE_TIME
import ru.fabit.utils.FULL_DATE_TIME_AND_MILLIS
import ru.fabit.utils.FULL_DATE_TIME_SHORT_DAY
import ru.fabit.utils.FULL_TIME
import ru.fabit.utils.TIME_DEFAULT
import ru.fabit.utils.TIME_DEFAULT_DATE_SHORT
import ru.fabit.utils.TIME_MINUTES_AND_SECONDS
import ru.fabit.utils.TIME_SHORT
import ru.fabit.utils.TIME_SHORT_DATE_DEFAULT
import ru.fabit.utils.TIME_SHORT_DATE_DEFAULT_SHORT_DAY

/**
 * yyyy-MM-dd'T'HH:mm:ss.SSS
 */
fun DateTime.toIsoWithMillis() = toString(DATE_TIME_ISO_AND_MILLIS)

/**
 * yyyy-MM-dd'T'HH:mm:ss.SSSZZ
 */
fun DateTime.toIsoWithMillisAndTZ() = toString(DATE_TIME_ISO_AND_MILLIS_AND_TZ)

/**
 * yyyy-MM-dd'T'HH:mm:ss
 */
fun DateTime.toIso() = toString(DATE_TIME_ISO)

/**
 * HH:mm:ss
 */
fun DateTime.to_HH_mm_ss() = toString(FULL_TIME)

/**
 * dd.MM.yyyy
 */
fun DateTime.to_dd_MM_yyyy() = toString(DATE_DEFAULT)

/**
 * dd MM.yyyy
 */
fun DateTime.to_dd__MM_yyyy() = toString(DATE_DEFAULT_DAY_SEPARATE)

/**
 * d MM.yyyy
 */
fun DateTime.to_d__MM_yyyy() = toString(DATE_DEFAULT_DAY_SEPARATE_SHORT_DAY)

/**
 * dd.MM.yy
 */
fun DateTime.to_dd_MM_yy() = toString(DATE_WITH_SHORT_YEAR)

/**
 * d.MM
 */
fun DateTime.to_d_MM() = toString(DATE_SHORT)

/**
 * d.MM.yy
 */
fun DateTime.to_d_MM_yy() = toString(DATE_SHORT_WITH_SHORT_YEAR)

/**
 * HH:mm
 */
fun DateTime.to_HH_mm() = toString(TIME_DEFAULT)

/**
 * H:mm
 */
fun DateTime.to_H_mm() = toString(TIME_SHORT)

/**
 * mm:ss
 */
fun DateTime.to_mm_ss() = toString(TIME_MINUTES_AND_SECONDS)

/**
 * HH:mm d.MM
 */
fun DateTime.to_HH_mm__d_MM() = toString(TIME_DEFAULT_DATE_SHORT)

/**
 * H:mm dd MM.yyyy
 */
fun DateTime.to_H_mm__dd__MM_yyyy() = toString(TIME_SHORT_DATE_DEFAULT)

/**
 * H:mm d MM.yyyy
 */
fun DateTime.to_H_mm__d__MM_yyyy() = toString(TIME_SHORT_DATE_DEFAULT_SHORT_DAY)

/**
 * d.MM.yyyy
 */
fun DateTime.to_d_MM_yyyy() = toString(DATE_DEFAULT_SHORT_DAY)

/**
 * d MMM
 */
fun DateTime.to_d__MMM() = toString(DATE_MEDIUM)

/**
 * d MMM HH:mm
 */
fun DateTime.to_d__MMM__HH_mm() = toString(DATE_MEDIUM_TIME_DEFAULT)

/**
 * d MMM, HH:mm
 */
fun DateTime.to_d__MMM__HH_mm_comma() = toString(DATE_MEDIUM_TIME_DEFAULT_WITH_COMMA)

/**
 * d MMM. HH:mm
 */
fun DateTime.to_d__MMM__HH_mm_point() = toString(DATE_MEDIUM_TIME_DEFAULT_WITH_POINT)

/**
 * d MMM,
 * HH:mm
 */
fun DateTime.to_d__MMM__HH_mm_comma_ln() = toString(DATE_MEDIUM_TIME_DEFAULT_WITH_COMMA_SPLIT)

/**
 * d.MM H:mm
 */
fun DateTime.to_d_MM__H_mm() = toString(DATE_SHORT_TIME_SHORT)

/**
 * d.MM, H:mm
 */
fun DateTime.to_d_MM__H_mm_comma() = toString(DATE_SHORT_TIME_SHORT_WITH_COMMA)

/**
 * d.MM. H:mm
 */
fun DateTime.to_d_MM__H_mm_point() = toString(DATE_SHORT_TIME_SHORT_WITH_POINT)

/**
 * d MMMM HH:mm
 */
fun DateTime.to_d__MMMM__HH_mm() = toString(DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT)

/**
 * d MMMM, HH:mm
 */
fun DateTime.to_d__MMMM__HH_mm_comma() = toString(
    DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT_WITH_COMMA
)

/**
 * d MMMM. HH:mm
 */
fun DateTime.to_d__MMMM__HH_mm_point() = toString(
    DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT_WITH_POINT
)

/**
 * d MMMM yyyy
 */
fun DateTime.to_d__MMMM__yyyy() = toString(DATE_DAY_SHORT_MONTH_LONG)

/**
 * d MMMM yyyy HH:mm
 */
fun DateTime.to_d__MMMM__yyyy__HH_mm() = toString(DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT)

/**
 * d MMMM yyyy, HH:mm
 */
fun DateTime.to_d__MMMM__yyyy__HH_mm_comma() =
    toString(DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT_WITH_COMMA)

/**
 * d MMMM yyyy. HH:mm
 */
fun DateTime.to_d__MMMM__yyyy__HH_mm_point() =
    toString(DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT_WITH_POINT)

/**
 * d MMM yyyy
 */
fun DateTime.to_d__MMM__yyyy() = toString(DATE_DAY_SHORT_MONTH_MEDIUM)

/**
 * dd.MM.yyyy HH:mm
 */
fun DateTime.to_dd_MM_yyyy__HH_mm() = toString(DATE_TIME_DEFAULT)

/**
 * d.MM.yyyy HH:mm
 */
fun DateTime.to_d_MM_yyyy__HH_mm() = toString(DATE_TIME_DEFAULT_SHORT_DAY)

/**
 * dd.MM.yyyy HH:mm:ss
 */
fun DateTime.to_dd_MM_yyyy__HH_mm_ss() = toString(FULL_DATE_TIME)

/**
 * d.MM.yyyy HH:mm:ss
 */
fun DateTime.to_d_MM_yyyy__HH_mm_ss() = toString(FULL_DATE_TIME_SHORT_DAY)

/**
 * dd.MM.yy HH:mm
 */
fun DateTime.to_dd_MM_yy__HH_mm() = toString(DATE_WITH_SHORT_YEAR_TIME_DEFAULT)

/**
 * d.MM.yy HH:mm
 */
fun DateTime.to_d_MM_yy__HH_mm() = toString(DATE_SHORT_WITH_SHORT_YEAR_TIME_DEFAULT)

/**
 * dd.MM.yyyy HH:mm:ss.SSS
 */
fun DateTime.to_dd_MM_yyyy__HH_mm_ss_sss() = toString(FULL_DATE_TIME_AND_MILLIS)
