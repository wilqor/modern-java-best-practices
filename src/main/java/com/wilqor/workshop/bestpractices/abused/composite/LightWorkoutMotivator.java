package com.wilqor.workshop.bestpractices.abused.composite;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;

/**
 * @author wilqor
 */
final class LightWorkoutMotivator implements WorkoutMotivator {
    LightWorkoutMotivator() {}

    @Override
    public String motivate(WorkoutDifficulty difficulty, Duration duration) {
        return "Good job! Another light workout done.";
    }
}
