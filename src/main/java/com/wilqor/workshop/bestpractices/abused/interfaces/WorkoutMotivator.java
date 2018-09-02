package com.wilqor.workshop.bestpractices.abused.interfaces;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;

/**
 * @author wilqor
 */
public interface WorkoutMotivator {
    String motivate(WorkoutDifficulty difficulty, Duration duration);

    static WorkoutMotivator defaultMotivator() {
        return new DefaultWorkoutMotivator();
    }
}
