package com.wilqor.workshop.bestpractices.familiar;

import java.util.Objects;
import java.util.Set;

/**
 * @author wilqor
 */
public final class WordOccurrences {
    private final int quantity;
    private final Set<String> synonyms;

    public WordOccurrences(int quantity, Set<String> synonyms) {
        if (quantity <= 0) { throw new IllegalArgumentException("Negative quantity: " + quantity); }
        this.quantity = quantity;
        this.synonyms = Set.copyOf(Objects.requireNonNull(synonyms));
    }

    public int getQuantity() {
        return quantity;
    }

    public Set<String> getSynonyms() {
        return synonyms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        var other = (WordOccurrences) o;
        return quantity == other.quantity && Objects.equals(synonyms, other.synonyms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, synonyms);
    }

    @Override
    public String toString() {
        return "WordOccurrences{quantity=" + quantity + ", synonyms=" + synonyms + '}';
    }
}
