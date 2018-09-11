package com.wilqor.workshop.bestpractices.modern.stream.mixed;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * @author wilqor
 */
final class SentenceCodesMapper {
    Map<String, Set<String>> loadSentenceCodes(List<String> sentences) {
        return sentences.stream()
                .collect(groupingBy(SentenceCodesMapper::firstWordChars,
                        Collectors.toSet()))
                .entrySet().stream()
                .sorted(comparing(e -> e.getValue().size()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    private static String firstWordChars(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (var w : words) {
            if (!w.isEmpty()) {
                stringBuilder.append(w.charAt(0));
            }
        }
        return stringBuilder.toString();
    }
}
