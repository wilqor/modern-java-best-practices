package com.wilqor.workshop.bestpractices.modern.optional;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Supplier;

/**
 * @author wilqor
 */
final class OptionalShowcase {
    private OptionalShowcase() {
    }

    public static void main(String[] args) {
        Optional<String> idOptional = Optional.of("0x12345");
        String alternative = idOptional.orElse("alternative id");
        String lazyAlternative = idOptional.orElseGet(getIdSupplier());
        idOptional.orElseThrow(() -> new IllegalArgumentException("No id found!"));
        idOptional.ifPresentOrElse(
                id -> System.out.println("Got id: " + id),
                () -> System.out.println("Well, no id this time."));

        Map<String, OptionalInt> incorrectUsageMap = Map.of(
                "one", OptionalInt.of(1),
                "two", OptionalInt.empty(),
                "three", OptionalInt.of(3)
        );
        incorrectUsageMap.get("two").ifPresent(num -> System.out.println("Found value for key two: " + num));
    }

    private static Supplier<String> getIdSupplier() {
        return () -> "lazily evaluated id";
    }

    private static Optional<String> neverReturnNullOptional(int number) {
        if (number > 0) {
            return Optional.of(String.valueOf(number));
        }
        return null;
    }
}
