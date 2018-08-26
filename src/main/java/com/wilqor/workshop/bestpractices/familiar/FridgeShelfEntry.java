package com.wilqor.workshop.bestpractices.familiar;

import java.util.Objects;
import java.util.Set;

/**
 * @author wilqor
 */
public final class FridgeShelfEntry {
    private final String productId;
    private final int quantity;
    private final Set<String> labels;

    public FridgeShelfEntry(String productId, int quantity, Set<String> labels) {
        this.productId = Objects.requireNonNull(productId);
        this.quantity = quantity;
        if (this.quantity <= 0.0) {
            throw new IllegalArgumentException("Negative quantity: " + this.quantity);
        }
        this.labels = Set.copyOf(Objects.requireNonNull(labels));
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Set<String> getLabels() {
        return labels;
    }

    @Override
    public String toString() {
        return "FridgeShelfEntry{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", labels=" + labels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FridgeShelfEntry)) {
            return false;
        }
        FridgeShelfEntry other = (FridgeShelfEntry) o;
        return other.productId.equals(productId)
                && other.quantity == quantity
                && other.labels.equals(labels);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + Integer.hashCode(quantity);
        result = 31 * result + labels.hashCode();
        return result;
    }
}
