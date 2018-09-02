package com.wilqor.workshop.bestpractices.modern.lambda.listener;

/**
 * @author wilqor
 */
public class WorkoutsCounter {
    private int workoutsCompleted;

    public WorkoutsCounter() {
        workoutsCompleted = 0;
    }

    public void addWorkoutCompleted() {
        workoutsCompleted++;
    }

    public int getWorkoutsCompleted() {
        return workoutsCompleted;
    }
}
