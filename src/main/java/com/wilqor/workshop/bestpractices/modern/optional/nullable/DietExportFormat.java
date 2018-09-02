package com.wilqor.workshop.bestpractices.modern.optional.nullable;

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

    private static final Map<String, DietExportFormat> NAME_TO_FORMAT = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));

    static DietExportFormat fromString(String formatName) {
        return NAME_TO_FORMAT.get(formatName);
    }
}
