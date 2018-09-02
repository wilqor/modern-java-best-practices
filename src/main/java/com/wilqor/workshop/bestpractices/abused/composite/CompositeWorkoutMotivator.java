package com.wilqor.workshop.bestpractices.abused.composite;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;

/**
 * @author wilqor
 */
final class CompositeWorkoutMotivator implements WorkoutMotivator {
    private final Map<WorkoutDifficulty, WorkoutMotivator> motivatorMap;
    private final WorkoutMotivator defaultMotivator;

    CompositeWorkoutMotivator(Map<WorkoutDifficulty, WorkoutMotivator> motivatorMap, WorkoutMotivator defaultMotivator) {
        this.motivatorMap = Map.copyOf(Objects.requireNonNull(motivatorMap));
        this.defaultMotivator = defaultMotivator;
    }

    @Override
    public String motivate(WorkoutDifficulty difficulty, Duration duration) {
        return motivatorMap.getOrDefault(difficulty, defaultMotivator).motivate(difficulty, duration);
    }
}
