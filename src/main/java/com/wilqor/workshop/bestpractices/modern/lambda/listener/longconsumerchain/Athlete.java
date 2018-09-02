package com.wilqor.workshop.bestpractices.modern.lambda.listener.longconsumerchain;

import com.wilqor.workshop.bestpractices.modern.lambda.listener.Workout;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutInterruptedException;

import java.util.List;
import java.util.Objects;
import java.util.function.LongConsumer;

/**
 * @author wilqor
 */
final class Athlete {
    private final LongConsumer workoutCompleteConsumer;

    Athlete(LongConsumer workoutCompleteConsumer) {
        this.workoutCompleteConsumer = Objects.requireNonNull(workoutCompleteConsumer);
    }

    void performWorkouts(List<Workout> workoutRoutine) throws WorkoutInterruptedException {
        for (Workout w : workoutRoutine) {
            try {
                Thread.sleep(w.getDuration().toMillis());
                workoutCompleteConsumer.accept(w.getCaloriesBurned());
            } catch (InterruptedException e) {
                throw new WorkoutInterruptedException(w, e);
            }
        }
    }
}
