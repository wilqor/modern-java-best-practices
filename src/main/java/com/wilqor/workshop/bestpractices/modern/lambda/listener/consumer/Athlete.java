package com.wilqor.workshop.bestpractices.modern.lambda.listener.consumer;

import com.wilqor.workshop.bestpractices.modern.lambda.listener.Workout;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutInterruptedException;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author wilqor
 */
final class Athlete {
    private final List<Consumer<Long>> workoutCompleteConsumers;

    Athlete(List<Consumer<Long>> workoutCompleteConsumers) {
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
        for (Consumer<Long> consumer : workoutCompleteConsumers) {
            consumer.accept(workout.getCaloriesBurned());
        }
    }
}
