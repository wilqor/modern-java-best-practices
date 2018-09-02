package com.wilqor.workshop.bestpractices.abused.composite;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;

/**
 * @author wilqor
 */
final class NotSpecifiedDifficultyWorkoutMotivator implements WorkoutMotivator {
    NotSpecifiedDifficultyWorkoutMotivator() {}

    @Override
    public String motivate(WorkoutDifficulty difficulty, Duration duration) {
        return "Workout difficulty not specified, but I guess it wasn't too easy, right?";
    }
}
