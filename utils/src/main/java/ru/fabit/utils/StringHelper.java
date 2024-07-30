package ru.fabit.utils;

import java.util.ArrayList;
import java.util.List;

import kotlin.Pair;

public class StringHelper {

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
