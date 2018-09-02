package com.wilqor.workshop.bestpractices.abused.composite;

import com.wilqor.workshop.bestpractices.abused.WorkoutDifficulty;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author wilqor
 */
public interface WorkoutMotivator {
    String motivate(WorkoutDifficulty difficulty, Duration duration);

    static WorkoutMotivator getInstance() {
        Map<WorkoutDifficulty, WorkoutMotivator> motivatorMap = new EnumMap<>(WorkoutDifficulty.class);
        motivatorMap.put(WorkoutDifficulty.HEAVY, new HeavyWorkoutMotivator());
        motivatorMap.put(WorkoutDifficulty.LIGHT, new LightWorkoutMotivator());
        WorkoutMotivator defaultMotivator = new NotSpecifiedDifficultyWorkoutMotivator();
        return new CompositeWorkoutMotivator(
                motivatorMap,
                defaultMotivator
        );
    }
}
