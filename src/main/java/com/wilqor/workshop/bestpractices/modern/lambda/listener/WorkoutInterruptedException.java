package com.wilqor.workshop.bestpractices.modern.lambda.listener;

/**
 * @author wilqor
 */
public class WorkoutInterruptedException extends Exception {
    public WorkoutInterruptedException(Workout workout, Throwable cause) {
        super("Interruped while performing workout: " + workout, cause);
    }
}
