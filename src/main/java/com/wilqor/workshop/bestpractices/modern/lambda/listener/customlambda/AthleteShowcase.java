package com.wilqor.workshop.bestpractices.modern.lambda.listener.customlambda;

import com.wilqor.workshop.bestpractices.modern.lambda.listener.CaloriesBurnedCounter;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.Workout;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutInterruptedException;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutsCounter;

import java.time.Duration;
import java.util.List;

/**
 * @author wilqor
 */
public class AthleteShowcase {
    private AthleteShowcase() {
    }

    public static void main(String[] args) throws WorkoutInterruptedException {
        final CaloriesBurnedCounter caloriesBurnedCounter = new CaloriesBurnedCounter();
        final WorkoutsCounter workoutsCounter = new WorkoutsCounter();
        List<Workout> workoutRoutine = List.of(
                new Workout(Duration.ofSeconds(5), 83),
                new Workout(Duration.ofSeconds(2), 3)
        );
        WorkoutCompleteListener printingListener = caloriesBurned -> System.out.println("Good job, another: " + caloriesBurned + " calories burned!");
        WorkoutCompleteListener caloriesBurnedListener = caloriesBurned -> caloriesBurnedCounter.addCaloriesBurned(caloriesBurned);
        WorkoutCompleteListener workoutCompletedListener = caloriesBurned -> workoutsCounter.addWorkoutCompleted();
        List<WorkoutCompleteListener> listeners = List.of(printingListener, caloriesBurnedListener, workoutCompletedListener);
        Athlete athlete = new Athlete(listeners);
        athlete.performWorkouts(workoutRoutine);
        System.out.println("Total calories burned: " + caloriesBurnedCounter.getTotalCaloriesBurned());
        System.out.println("Total workouts completed: " + workoutsCounter.getWorkoutsCompleted());
    }
}
