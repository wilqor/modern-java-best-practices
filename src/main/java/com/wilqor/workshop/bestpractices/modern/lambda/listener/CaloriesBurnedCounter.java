package com.wilqor.workshop.bestpractices.modern.lambda.listener;

/**
 * @author wilqor
 */
public class CaloriesBurnedCounter {
    private long totalCaloriesBurned;

    public CaloriesBurnedCounter() {
        totalCaloriesBurned = 0;
    }

    public void addCaloriesBurned(long caloriesBurned) {
        if (caloriesBurned < 0L) {
            throw new IllegalArgumentException("caloriesBurned: " + caloriesBurned);
        }
        totalCaloriesBurned += caloriesBurned;
    }

    public long getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }
}
