package com.example.fitness.service;

import com.example.fitness.model.User;
import com.example.fitness.model.WorkoutPlan;
import org.springframework.stereotype.Service;

@Service
public class FitnessApp {

    public User getUserById(int id) {
        return new User(id, "Alex", 22, 70.5);
    }

    public User addUser(User user) {
        return user;
    }

    public WorkoutPlan getWorkoutById(int id) {
        return new WorkoutPlan(id, "Cardio", 45);
    }

    public WorkoutPlan addWorkout(WorkoutPlan workout) {
        return workout;
    }
}

