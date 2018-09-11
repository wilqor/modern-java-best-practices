package com.wilqor.workshop.bestpractices.modern.stream.pure;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * @author wilqor
 */
final class SentenceCodesMapper {
    Map<String, Set<String>> loadSentenceCodes(List<String> sentences) {
        return sentences.stream()
                .collect(groupingBy(
                        sentence -> Stream.of(sentence.split("\\s+"))
                                .map(String::chars)
                                .map(intStream -> intStream.limit(1).findFirst())
                                .map(OptionalInt::getAsInt)
                                .collect(StringBuilder::new,
                                        StringBuilder::appendCodePoint,
                                        StringBuilder::append)
                                .toString(),
                        Collectors.toSet()))
                .entrySet().stream()
                .sorted(comparing(e -> e.getValue().size()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
