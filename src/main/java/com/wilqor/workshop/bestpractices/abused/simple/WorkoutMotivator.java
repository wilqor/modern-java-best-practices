package com.wilqor.workshop.bestpractices.abused.simple;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;

/**
 * @author wilqor
 */
public final class WorkoutMotivator {
    public WorkoutMotivator() {
    }

    public String motivate(WorkoutDifficulty difficulty, Duration duration) {
        switch (difficulty) {
            case HEAVY:
                return "Wow, that was a tough one and you managed to do it for: " + duration.toMinutes() + " minutes!";
            case LIGHT:
                return "Good job! Another light workout done.";
            default:
                return "Workout difficulty not specified, but I guess it wasn't too easy, right?";
        }
    }
}
