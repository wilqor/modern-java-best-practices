package com.wilqor.workshop.bestpractices.modern.methodref;

import com.wilqor.workshop.bestpractices.familiar.FridgeShelfEntry;
import com.wilqor.workshop.bestpractices.modern.lambda.TriFunction;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * @author wilqor
 */
final class MethodRefShowcase {
    private MethodRefShowcase() {
    }

    public static void main(String[] args) {
        // static
        Function<Integer, String> intToStr = String::valueOf;
        Function<Integer, String> customIntToStr = MethodRefShowcase::customIntToStr;
        // bound
        Consumer<String> soutConsumer = System.out::println;
        // unbound
        ToIntFunction<String> strLength = String::length;
        // class constructor
        TriFunction<String, Integer, Set<String>, FridgeShelfEntry>
                fridgeShelfEntryConstructor = FridgeShelfEntry::new;
    }

    private static String customIntToStr(Integer num) {
        return "An integer: " + num;
    }
}
