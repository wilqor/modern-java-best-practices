package com.wilqor.workshop.bestpractices;

import com.wilqor.workshop.bestpractices.familiar.FoodProductLoader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * @author wilqor
 */
public class Application {
    public static void main(String[] args) throws IOException, URISyntaxException {
        var loader = new FoodProductLoader(",");
        URI foodProductsUri = Application.class.getResource("food_products.txt").toURI();
        loader.loadFoodProducts(Paths.get(foodProductsUri))
                .forEach(System.out::println);
    }
}
