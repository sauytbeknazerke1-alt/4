package com.example.fitness.controller;

import com.example.fitness.model.WorkoutPlan;
import com.example.fitness.service.FitnessApp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutPlanController {

    private final FitnessApp fitnessApp;

    public WorkoutPlanController(FitnessApp fitnessApp) {
        this.fitnessApp = fitnessApp;
    }

    @GetMapping("/{id}")
    public WorkoutPlan getWorkout(@PathVariable int id) {
        return fitnessApp.getWorkoutById(id);
    }

    @PostMapping
    public WorkoutPlan createWorkout(@RequestBody WorkoutPlan workout) {
        return fitnessApp.addWorkout(workout);
    }
}

