package com.wilqor.workshop.bestpractices.abused.composite;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;

/**
 * @author wilqor
 */
final class HeavyWorkoutMotivator implements WorkoutMotivator {
    HeavyWorkoutMotivator() {}

    @Override
    public String motivate(WorkoutDifficulty difficulty, Duration duration) {
        return "Wow, that was a tough one and you managed to do it for: " + duration.toMinutes() + " minutes!";
    }
}
