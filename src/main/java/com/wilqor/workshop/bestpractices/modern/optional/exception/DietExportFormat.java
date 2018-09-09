package com.wilqor.workshop.bestpractices.modern.optional.exception;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author wilqor
 */
enum DietExportFormat {
    JSON,
    XML,
    CSV,
    PDF;

    private static final Map<String, DietExportFormat> NAME_TO_FORMAT = Stream
            .of(values())
            .collect(toMap(Object::toString, e -> e));

    static DietExportFormat fromString(String formatName) {
        if (NAME_TO_FORMAT.containsKey(formatName)) {
            return NAME_TO_FORMAT.get(formatName);
        }
        throw new IllegalArgumentException("No such format: " + formatName);
    }
}
