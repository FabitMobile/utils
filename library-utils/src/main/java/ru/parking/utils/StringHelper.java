package ru.parking.utils;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {

    /**
     * Checks if given string is empty or contains only empty characters (for example, whitespaces)
     *
     * @param string string to check. May be null
     * @return true, if given string is null, has 0 length or contains only empty characters. Otherwise returns false.
     */
    public static boolean isEmptyOrWhitespaced(String string) {
        return string == null || string.length() == 0 || string.matches("\\s*");
    }

    public static List<Pair<Integer, Integer>> getAllOccurrencesOfSubstringStartEndPairs(String target, String substring) {
        if (substring == null) {
            return null;
        }

        int startIndex = target.indexOf(substring);
        if (startIndex == -1) {
            return null;
        }

        List<Pair<Integer, Integer>> occurrencesStartEndPositionsPairs = new ArrayList<>();
        occurrencesStartEndPositionsPairs.add(new Pair<>(startIndex, startIndex + substring.length()));
        while (startIndex >= 0) {
            occurrencesStartEndPositionsPairs.add(new Pair<>(startIndex, startIndex + substring.length()));
            startIndex = target.indexOf(substring, startIndex + 1);
        }
        return occurrencesStartEndPositionsPairs;
    }
}
