package ru.fabit.utils

const val HOURS = "HH"
const val HOURS_SHORT = "H"
const val MINUTES = "mm"
const val SECONDS = "ss"
const val MILLIS = "SSS"

const val DAY = "dd"
const val DAY_SHORT = "d"
const val MONTH = "MM"
const val MONTH_MEDIUM = "MMM"
const val MONTH_LONG = "MMMM"
const val YEAR = "yyyy"
const val YEAR_SHORT = "yy"

const val WEEKDAY = "EE"

const val TIME_ZONE_OFFSET = "+00:00"
const val TIME_ZONE = "ZZ"

const val DATE_TIME_ISO = "yyyy-MM-dd'T'HH:mm:ss"

/**
 * yyyy-MM-dd'T'HH:mm:ss.SSS
 */
const val DATE_TIME_ISO_AND_MILLIS = "$DATE_TIME_ISO.$MILLIS"

/**
 * yyyy-MM-dd'T'HH:mm:ss.SSSZZ
 */
const val DATE_TIME_ISO_AND_MILLIS_AND_TZ = "$DATE_TIME_ISO_AND_MILLIS$TIME_ZONE"

/**
 * HH:mm:ss
 */
const val FULL_TIME = "$HOURS:$MINUTES:$SECONDS"

/**
 * dd.MM.yyyy
 */
const val DATE_DEFAULT = "$DAY.$MONTH.$YEAR"

/**
 * dd MM.yyyy
 */
const val DATE_DEFAULT_DAY_SEPARATE = "$DAY $MONTH.$YEAR"

/**
 * d MM.yyyy
 */
const val DATE_DEFAULT_DAY_SEPARATE_SHORT_DAY = "$DAY_SHORT $MONTH.$YEAR"

/**
 * dd.MM.yy
 */
const val DATE_WITH_SHORT_YEAR = "$DAY.$MONTH.$YEAR_SHORT"

/**
 * d.MM
 */
const val DATE_SHORT = "$DAY_SHORT.$MONTH"

/**
 * d.MM.yy
 */
const val DATE_SHORT_WITH_SHORT_YEAR = "$DATE_SHORT.$YEAR_SHORT"

/**
 * HH:mm
 */
const val TIME_DEFAULT = "$HOURS:$MINUTES"

/**
 * H:mm
 */
const val TIME_SHORT = "$HOURS_SHORT:$MINUTES"

/**
 * mm:ss
 */
const val TIME_MINUTES_AND_SECONDS = "$MINUTES:$SECONDS"

/**
 * HH:mm d.MM
 */
const val TIME_DEFAULT_DATE_SHORT = "$TIME_DEFAULT $DATE_SHORT"

/**
 * H:mm dd MM.yyyy
 */
const val TIME_SHORT_DATE_DEFAULT = "$TIME_SHORT $DATE_DEFAULT_DAY_SEPARATE"

/**
 * H:mm d MM.yyyy
 */
const val TIME_SHORT_DATE_DEFAULT_SHORT_DAY = "$TIME_SHORT $DATE_DEFAULT_DAY_SEPARATE_SHORT_DAY"

/**
 * d.MM.yyyy
 */
const val DATE_DEFAULT_SHORT_DAY = "$DAY_SHORT.$MONTH.$YEAR"

/**
 * d MMM
 */
const val DATE_MEDIUM = "$DAY_SHORT $MONTH_MEDIUM"

/**
 * d MMM HH:mm
 */
const val DATE_MEDIUM_TIME_DEFAULT = "$DATE_MEDIUM $TIME_DEFAULT"

/**
 * d MMM, HH:mm
 */
const val DATE_MEDIUM_TIME_DEFAULT_WITH_COMMA = "$DATE_MEDIUM, $TIME_DEFAULT"

/**
 * d MMM. HH:mm
 */
const val DATE_MEDIUM_TIME_DEFAULT_WITH_POINT = "$DATE_MEDIUM. $TIME_DEFAULT"

/**
 * d MMM,
 * HH:mm
 */
const val DATE_MEDIUM_TIME_DEFAULT_WITH_COMMA_SPLIT = "$DATE_MEDIUM,\n$TIME_DEFAULT"

/**
 * d.MM H:mm
 */
const val DATE_SHORT_TIME_SHORT = "$DATE_SHORT $TIME_SHORT"

/**
 * d.MM, H:mm
 */
const val DATE_SHORT_TIME_SHORT_WITH_COMMA = "$DATE_SHORT, $TIME_SHORT"

/**
 * d.MM. H:mm
 */
const val DATE_SHORT_TIME_SHORT_WITH_POINT = "$DATE_SHORT. $TIME_SHORT"

/**
 * d MMMM HH:mm
 */
const val DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT =
    "$DAY_SHORT $MONTH_LONG $TIME_DEFAULT"

/**
 * d MMMM, HH:mm
 */
const val DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT_WITH_COMMA =
    "$DAY_SHORT $MONTH_LONG, $TIME_DEFAULT"

/**
 * d MMMM. HH:mm
 */
const val DATE_DAY_SHORT_MONTH_LONG_WITHOUT_YEAR_TIME_DEFAULT_WITH_POINT =
    "$DAY_SHORT $MONTH_LONG. $TIME_DEFAULT"

/**
 * d MMMM yyyy
 */
const val DATE_DAY_SHORT_MONTH_LONG = "$DAY_SHORT $MONTH_LONG $YEAR"

/**
 * d MMMM yyyy HH:mm
 */
const val DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT = "$DATE_DAY_SHORT_MONTH_LONG $TIME_DEFAULT"

/**
 * d MMMM yyyy, HH:mm
 */
const val DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT_WITH_COMMA =
    "$DATE_DAY_SHORT_MONTH_LONG, $TIME_DEFAULT"

/**
 * d MMMM yyyy. HH:mm
 */
const val DATE_DAY_SHORT_MONTH_LONG_TIME_DEFAULT_WITH_POINT =
    "$DATE_DAY_SHORT_MONTH_LONG. $TIME_DEFAULT"

/**
 * d MMM yyyy
 */
const val DATE_DAY_SHORT_MONTH_MEDIUM = "$DAY_SHORT $MONTH_MEDIUM $YEAR"

/**
 * dd.MM.yyyy HH:mm
 */
const val DATE_TIME_DEFAULT = "$DATE_DEFAULT $TIME_DEFAULT"

/**
 * d.MM.yyyy HH:mm
 */
const val DATE_TIME_DEFAULT_SHORT_DAY = "$DATE_DEFAULT_SHORT_DAY $TIME_DEFAULT"

/**
 * dd.MM.yyyy HH:mm:ss
 */
const val FULL_DATE_TIME = "$DATE_DEFAULT $FULL_TIME"

/**
 * d.MM.yyyy HH:mm:ss
 */
const val FULL_DATE_TIME_SHORT_DAY = "$DATE_DEFAULT_SHORT_DAY $FULL_TIME"

/**
 * dd.MM.yy HH:mm
 */
const val DATE_WITH_SHORT_YEAR_TIME_DEFAULT = "$DATE_WITH_SHORT_YEAR $TIME_DEFAULT"

/**
 * d.MM.yy HH:mm
 */
const val DATE_SHORT_WITH_SHORT_YEAR_TIME_DEFAULT = "$DATE_SHORT_WITH_SHORT_YEAR $TIME_DEFAULT"

/**
 * dd.MM.yyyy HH:mm:ss.SSS
 */
const val FULL_DATE_TIME_AND_MILLIS = "$FULL_DATE_TIME.$MILLIS"