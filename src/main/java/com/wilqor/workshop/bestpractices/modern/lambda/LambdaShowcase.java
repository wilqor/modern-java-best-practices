package com.wilqor.workshop.bestpractices.modern.lambda;

import com.wilqor.workshop.bestpractices.familiar.FridgeShelfEntry;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.*;

/**
 * @author wilqor
 */
final class LambdaShowcase {
    private LambdaShowcase() {}

    public static void main(String[] args) {
        Consumer<String> soutConsumer = str -> System.out.println(str);
        Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();
        UnaryOperator<Integer> square = num -> num * num;
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        Function<Integer, String> intToStr = num -> String.valueOf(num);
        Predicate<String> longerThan10Characters = str -> str.length() > 10;

        TriFunction<String, Integer, Set<String>, FridgeShelfEntry> fridgeShelfEntryConstructor =
                (id, quantity, labels) -> new FridgeShelfEntry(id, quantity, labels);
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);

        default <X> TriFunction<T, U, V, X> andThen(Function<? super R, ? extends X> after) {
            Objects.requireNonNull(after);
            return (T t, U u, V v) -> after.apply(apply(t, u, v));
        }
    }


}
