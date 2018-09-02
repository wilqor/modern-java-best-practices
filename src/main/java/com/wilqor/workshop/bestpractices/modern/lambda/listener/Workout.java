package com.wilqor.workshop.bestpractices.modern.lambda.listener;

import java.time.Duration;
import java.util.Objects;

/**
 * @author wilqor
 */
public final class Workout {
    private final Duration duration;
    private final int caloriesPerSecond;

    public Workout(Duration duration, int caloriesPerSecond) {
        this.duration = Objects.requireNonNull(duration);
        this.caloriesPerSecond = caloriesPerSecond;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getCaloriesPerSecond() {
        return caloriesPerSecond;
    }

    public long getCaloriesBurned() {
        return duration.toSeconds() * caloriesPerSecond;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "duration=" + duration +
                ", caloriesPerSecond=" + caloriesPerSecond +
                '}';
    }
}
