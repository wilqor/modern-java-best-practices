package com.wilqor.workshop.bestpractices.modern.stream.mixed;

import com.wilqor.workshop.bestpractices.modern.stream.FoodProduct;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

/**
 * @author wilqor
 */
public class TopFoodProductsShowcase {
    private TopFoodProductsShowcase() {
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(TopFoodProductsShowcase.class.getClassLoader().getResource("files/food_products.txt").toURI());
        Map<Integer, Set<FoodProduct>> lowestCarbFoods = new TopFoodProductsLoader().loadLowestCarbFoods(path, 300, 10);
        lowestCarbFoods.forEach((key, value) -> {
            System.out.println("***");
            System.out.println("Foods with: " + key + " carbs");
            value.forEach(System.out::println);
        });
    }
}