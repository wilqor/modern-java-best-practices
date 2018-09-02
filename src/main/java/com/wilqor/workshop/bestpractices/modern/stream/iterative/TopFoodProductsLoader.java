package com.wilqor.workshop.bestpractices.modern.stream.iterative;

import com.wilqor.workshop.bestpractices.modern.stream.FoodProduct;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

/**
 * @author wilqor
 */
final class TopFoodProductsLoader {
    private static final String PRODUCT_LINE_PARTS_SEPARATOR = ",";

    TopFoodProductsLoader() {
    }

    Map<Integer, Set<FoodProduct>> loadLowestCarbFoods(Path inputFilePath, int maxKcal, int maxFoodsCount) throws IOException {
        Set<FoodProduct> foodsBelowKcalThreshold = loadFoodProductsBelowThreshold(inputFilePath, maxKcal);
        return findLowestCarbFoods(maxFoodsCount, foodsBelowKcalThreshold);
    }

    private Set<FoodProduct> loadFoodProductsBelowThreshold(Path inputFilePath, int maxKcal) throws IOException {
        Set<FoodProduct> foodsBelowKcalThreshold = new TreeSet<>(comparing(FoodProduct::getCarbohydrates));
        try (Scanner scanner = new Scanner(inputFilePath)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                FoodProduct product = convertLineToProduct(line);
                if (product.getKcal() <= maxKcal) {
                    foodsBelowKcalThreshold.add(product);
                }
            }
        }
        return foodsBelowKcalThreshold;
    }

    private FoodProduct convertLineToProduct(String line) {
        String[] lineParts = line.split(PRODUCT_LINE_PARTS_SEPARATOR);
        return FoodProduct.builder()
                .id(lineParts[0])
                .name(lineParts[1])
                .proteins(Integer.valueOf(lineParts[2]))
                .carbohydrates(Integer.valueOf(lineParts[3]))
                .fats(Integer.valueOf(lineParts[4]))
                .build();
    }

    private Map<Integer, Set<FoodProduct>> findLowestCarbFoods(int maxFoodsCount, Set<FoodProduct> foodsBelowKcalThreshold) {
        Map<Integer, Set<FoodProduct>> lowestCarbFoods = new TreeMap<>(naturalOrder());
        int foodsCount = 0;
        for (FoodProduct product : foodsBelowKcalThreshold) {
            if (foodsCount <= maxFoodsCount) {
                lowestCarbFoods.computeIfAbsent(product.getCarbohydrates(), (ignored) -> new TreeSet<>(comparing(FoodProduct::getName))).add(product);
                foodsCount++;
            } else {
                break;
            }
        }
        return lowestCarbFoods;
    }
}