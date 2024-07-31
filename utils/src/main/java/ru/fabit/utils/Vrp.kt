package ru.fabit.utils

/**
 * Vehicle Registration Plate - Государственный регистрационный знак
 */
@JvmInline
value class Vrp(val value: String?) {

    infix fun equalTo(other: Vrp): Boolean {
        var areEquals = false
        if (value != null && other.value != null) {
            val vrp1InCyrillic =
                Transliterate.latinToCyrillic(value.replace(" ", "").uppercase()).uppercase()
            val vrp2InCyrillic =
                Transliterate.latinToCyrillic(other.value.replace(" ", "").uppercase())
                    .uppercase()
            areEquals = vrp1InCyrillic == vrp2InCyrillic
        }
        return areEquals
    }

    fun transliterate(): Vrp {
        return when {
            value == null -> Vrp(null)
            value.isEmpty() -> Vrp(value)
            value[0].code >= intCodeRussian_A -> cyrillicToLatin()
            value[0].code >= intCodeLatin_A -> latinToCyrillic()
            else -> Vrp(value)
        }
    }

    fun latinToCyrillic(): Vrp {
        if (value == null)
            return Vrp(null)

        val rusVrp = StringBuilder()
        value.uppercase().toCharArray().forEach { char ->
            when (char) {
                'A' -> rusVrp.append('А')
                'B' -> rusVrp.append('В')
                'E' -> rusVrp.append('Е')
                'K' -> rusVrp.append('К')
                'M' -> rusVrp.append('М')
                'H' -> rusVrp.append('Н')
                'O' -> rusVrp.append('О')
                'P' -> rusVrp.append('Р')
                'C' -> rusVrp.append('С')
                'T' -> rusVrp.append('Т')
                'Y' -> rusVrp.append('У')
                'X' -> rusVrp.append('Х')
                else -> rusVrp.append(char)
            }
        }
        return Vrp(rusVrp.toString())
    }

    fun cyrillicToLatin(): Vrp {
        if (value == null)
            return Vrp(null)

        val latinVrp = StringBuilder()
        value.uppercase().toCharArray().forEach { char ->
            when (char) {
                'А' -> latinVrp.append('A')
                'В' -> latinVrp.append('B')
                'Е' -> latinVrp.append('E')
                'К' -> latinVrp.append('K')
                'М' -> latinVrp.append('M')
                'Н' -> latinVrp.append('H')
                'О' -> latinVrp.append('O')
                'Р' -> latinVrp.append('P')
                'С' -> latinVrp.append('C')
                'Т' -> latinVrp.append('T')
                'У' -> latinVrp.append('Y')
                'Х' -> latinVrp.append('X')
                else -> latinVrp.append(char)
            }
        }
        return Vrp(latinVrp.toString())
    }

    object Transliterate {
        operator fun invoke(vrp: String): String {
            return Vrp(vrp).transliterate().value!!
        }

        fun latinToCyrillic(vrp: String): String {
            return Vrp(vrp).latinToCyrillic().value!!
        }

        fun cyrillicToLatin(vrp: String): String {
            return Vrp(vrp).cyrillicToLatin().value!!
        }
    }
}

object VrpUtil {
    @JvmStatic
    fun transliterateVrpChar(vrp: String): String {
        return Vrp.Transliterate(vrp)
    }

    @JvmStatic
    fun transliterateLatinToCyrillicVrp(vrp: String): String {
        return Vrp.Transliterate.latinToCyrillic(vrp)
    }

    @JvmStatic
    fun transliterateCyrillicToLatinVrp(vrp: String): String {
        return Vrp.Transliterate.cyrillicToLatin(vrp)
    }

    @JvmStatic
    fun equals(vrp1: String?, vrp2: String?): Boolean {
        return Vrp(vrp1) equalTo Vrp(vrp2)
    }
}

private const val intCodeRussian_A = 1072
private const val intCodeLatin_A = 97