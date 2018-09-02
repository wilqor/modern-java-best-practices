package com.wilqor.workshop.bestpractices.modern.lambda.listener.consumer;

import com.wilqor.workshop.bestpractices.modern.lambda.listener.CaloriesBurnedCounter;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.Workout;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutInterruptedException;
import com.wilqor.workshop.bestpractices.modern.lambda.listener.WorkoutsCounter;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

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
        Consumer<Long> printingConsumer = caloriesBurned -> System.out.println("Good job, another: " + caloriesBurned + " calories burned!");
        Consumer<Long> caloriesBurnedConsumer = caloriesBurned -> caloriesBurnedCounter.addCaloriesBurned(caloriesBurned);
        Consumer<Long> workoutCompletedConsumer = caloriesBurned -> workoutsCounter.addWorkoutCompleted();
        List<Consumer<Long>> consumers = List.of(printingConsumer, caloriesBurnedConsumer, workoutCompletedConsumer);
        Athlete athlete = new Athlete(consumers);
        athlete.performWorkouts(workoutRoutine);
        System.out.println("Total calories burned: " + caloriesBurnedCounter.getTotalCaloriesBurned());
        System.out.println("Total workouts completed: " + workoutsCounter.getWorkoutsCompleted());
    }
}
