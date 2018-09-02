package com.wilqor.workshop.bestpractices.modern.lambda.listener.longconsumer;

import com.wilqor.workshop.bestpractices.modern.lambda.listener.Workout;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutInterruptedException;

import java.util.List;
import java.util.Objects;
import java.util.function.LongConsumer;

/**
 * @author wilqor
 */
final class Athlete {
    private final List<LongConsumer> workoutCompleteConsumers;

    Athlete(List<LongConsumer> workoutCompleteConsumers) {
        this.workoutCompleteConsumers = List.copyOf(Objects.requireNonNull(workoutCompleteConsumers));
    }

    void performWorkouts(List<Workout> workoutRoutine) throws WorkoutInterruptedException {
        for (Workout w : workoutRoutine) {
            try {
                Thread.sleep(w.getDuration().toMillis());
                notifyWorkoutCompleteListeners(w);
            } catch (InterruptedException e) {
                throw new WorkoutInterruptedException(w, e);
            }
        }
    }

    private void notifyWorkoutCompleteListeners(Workout workout) {
        for (LongConsumer consumer : workoutCompleteConsumers) {
            consumer.accept(workout.getCaloriesBurned());
        }
    }
}
