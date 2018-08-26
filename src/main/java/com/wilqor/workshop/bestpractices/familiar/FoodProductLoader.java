package com.wilqor.workshop.bestpractices.familiar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wilqor
 */
public class FoodProductLoader {
    private static final int FOOD_PRODUCT_FIELDS_COUNT = 5;
    private final String fieldsSeparator;

    public FoodProductLoader(String fieldsSeparator) {
        this.fieldsSeparator = Objects.requireNonNull(fieldsSeparator);
    }

    public List<FoodProduct> loadFoodProducts(Path path) throws IOException {
        try (Stream<String> line = Files.lines(path)) {
            return line.map(this::lineToProduct)
                    .collect(Collectors.toList());
        }
    }

    private FoodProduct lineToProduct(String line) {
        String[] lineParts = line.split(fieldsSeparator);
        if (lineParts.length != FOOD_PRODUCT_FIELDS_COUNT) {
            throw new IllegalArgumentException("FoodProduct line: '" + line + "' does not have: "
                    + FOOD_PRODUCT_FIELDS_COUNT + " field parts");
        }
        return FoodProduct.builder()
                .id(lineParts[0])
                .name(lineParts[1])
                .proteins(Integer.valueOf(lineParts[2]))
                .carbohydrates(Integer.valueOf(lineParts[3]))
                .fats(Integer.valueOf(lineParts[4]))
                .build();
    }
}
