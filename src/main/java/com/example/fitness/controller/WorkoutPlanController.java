package com.example.fitness.controller;

import com.example.fitness.model.WorkoutPlan;
import com.example.fitness.service.WorkoutPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutPlanController {

    private final WorkoutPlanService service;

    public WorkoutPlanController(WorkoutPlanService service) {
        this.service = service;
    }

    @PostMapping
    public String createWorkout(@RequestBody WorkoutPlan workout) {
        service.createWorkout(workout);
        return "Workout created";
    }

    @GetMapping("/{id}")
    public WorkoutPlan getWorkout(@PathVariable int id) {
        return service.getWorkout(id);
    }

    @PutMapping
    public String updateWorkout(@RequestBody WorkoutPlan workout) {
        service.updateWorkout(workout);
        return "Workout updated";
    }

    @DeleteMapping("/{id}")
    public String deleteWorkout(@PathVariable int id) {
        service.deleteWorkout(id);
        return "Workout deleted";
    }
}



