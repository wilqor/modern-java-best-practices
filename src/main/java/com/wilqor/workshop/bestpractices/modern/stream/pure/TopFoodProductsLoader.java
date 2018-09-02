package com.wilqor.workshop.bestpractices.modern.stream.pure;

import com.wilqor.workshop.bestpractices.modern.stream.FoodProduct;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

/**
 * @author wilqor
 */
final class TopFoodProductsLoader {
    TopFoodProductsLoader() {
    }

    private static final String PRODUCT_LINE_PARTS_SEPARATOR = ",";

    Map<Integer, Set<FoodProduct>> loadLowestCarbFoods(Path inputFilePath, int maxKcal, int maxFoodsCount) throws IOException {
        try (Stream<String> lines = Files.lines(inputFilePath)) {
            return lines.map(l -> l.split(PRODUCT_LINE_PARTS_SEPARATOR))
                    .map(lineParts -> FoodProduct.builder()
                            .id(lineParts[0])
                            .name(lineParts[1])
                            .proteins(Integer.valueOf(lineParts[2]))
                            .carbohydrates(Integer.valueOf(lineParts[3]))
                            .fats(Integer.valueOf(lineParts[4]))
                            .build())
                    .filter(food -> food.getKcal() <= maxKcal)
                    .sorted(comparing(FoodProduct::getCarbohydrates))
                    .limit(maxFoodsCount)
                    .collect(groupingBy(
                            FoodProduct::getCarbohydrates,
                            TreeMap::new,
                            toCollection(() -> new TreeSet<>(comparing(FoodProduct::getName)))
                    ));
        }
    }
}