package com.wilqor.workshop.bestpractices.modern.stream;

import java.util.Objects;

/**
 * @author wilqor
 */
public final class FoodProduct {
    private final String id;
    private final String name;
    private final int proteins;
    private final int carbohydrates;
    private final int fats;

    private FoodProduct(Builder builder) {
        id = Objects.requireNonNull(builder.id);
        name = Objects.requireNonNull(builder.name);
        proteins = checkNotNegative(builder.proteins, "Proteins");
        carbohydrates = checkNotNegative(builder.carbohydrates, "Carbohydrates");
        fats = checkNotNegative(builder.fats, "Fats");
    }

    private int checkNotNegative(int count, String nutrient) {
        if (count < 0) {
            throw new IllegalArgumentException("Negative count of " + nutrient + ":" + count);
        }
        return count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProteins() {
        return proteins;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getFats() {
        return fats;
    }

    public int getKcal() {
        return proteins * 4 + carbohydrates * 4 + fats * 9;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", proteins=" + proteins +
                ", carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                '}';
    }

    public static final class Builder {
        private String id;
        private String name;
        private int proteins;
        private int carbohydrates;

        private int fats;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder proteins(int proteins) {
            this.proteins = proteins;
            return this;
        }

        public Builder carbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public Builder fats(int fats) {
            this.fats = fats;
            return this;
        }

        public FoodProduct build() {
            return new FoodProduct(this);
        }
    }
}
