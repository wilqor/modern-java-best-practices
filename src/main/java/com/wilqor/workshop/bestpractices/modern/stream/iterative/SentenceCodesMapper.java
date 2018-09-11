package com.wilqor.workshop.bestpractices.modern.stream.iterative;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * @author wilqor
 */
final class SentenceCodesMapper {
    Map<String, Set<String>> loadSentenceCodes(List<String> sentences) {
        Map<String, Set<String>> codesSentences = new HashMap<>();
        for (var s : sentences) {
            codesSentences.computeIfAbsent(firstWordChars(s), k -> new HashSet<>()).add(s);
        }
        Set<Map.Entry<String, Set<String>>> sorted = new TreeSet<>(comparing(e -> e.getValue().size()));
        sorted.addAll(codesSentences.entrySet());
        LinkedHashMap<String, Set<String>> result = new LinkedHashMap<>();
        for (var e : sorted) {
            result.putIfAbsent(e.getKey(), e.getValue());
        }
        return result;
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
