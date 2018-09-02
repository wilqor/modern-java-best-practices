package com.wilqor.workshop.bestpractices.modern.lambda;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author wilqor
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);

    default <X> TriFunction<T, U, V, X> andThen(Function<? super R, ? extends X> after) {
        Objects.requireNonNull(after);
        return (T t, U u, V v) -> after.apply(apply(t, u, v));
    }
}
