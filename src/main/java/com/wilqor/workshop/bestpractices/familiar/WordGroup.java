package com.wilqor.workshop.bestpractices.familiar;

import java.util.Objects;
import java.util.Set;

/**
 * @author wilqor
 */
public final class WordGroup {
    private final long index;
    private final Set<String> words;

    public WordGroup(long index, Set<String> words) {
        if (index <= 0) { throw new IllegalArgumentException("Negative index: " + index); }
        this.index = index;
        this.words = Set.copyOf(Objects.requireNonNull(words));
    }

    public long getIndex() {
        return index;
    }

    public Set<String> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        var other = (WordGroup) o;
        return index == other.index && Objects.equals(words, other.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, words);
    }

    @Override
    public String toString() {
        return "WordGroup{index=" + index + ", words=" + words + '}';
    }
}
