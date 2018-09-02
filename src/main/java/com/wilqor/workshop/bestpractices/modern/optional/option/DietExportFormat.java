package com.wilqor.workshop.bestpractices.modern.optional.option;

import java.util.Map;
import java.util.Optional;
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

    static Optional<DietExportFormat> fromString(String formatName) {
        return Optional.ofNullable(NAME_TO_FORMAT.get(formatName));
    }
}
