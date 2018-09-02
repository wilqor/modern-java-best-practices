package com.wilqor.workshop.bestpractices.modern.lambda.listener.customlambda;

import com.wilqor.workshop.bestpractices.modern.lambda.listener.Workout;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutInterruptedException;

import java.util.List;
import java.util.Objects;

/**
 * @author wilqor
 */
final class Athlete {
    private final List<WorkoutCompleteListener> workoutCompleteListeners;

    Athlete(List<WorkoutCompleteListener> workoutCompleteListeners) {
        this.workoutCompleteListeners = List.copyOf(Objects.requireNonNull(workoutCompleteListeners));
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
        for (WorkoutCompleteListener listener : workoutCompleteListeners) {
            listener.onWorkoutComplete(workout.getCaloriesBurned());
        }
    }
}
