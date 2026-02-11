package com.example.fitness.service;

import com.example.fitness.dao.WorkoutPlanDAO;
import com.example.fitness.exception.ResourceNotFoundException;
import com.example.fitness.model.WorkoutPlan;
import org.springframework.stereotype.Service;

@Service
public class WorkoutPlanService {

    private final WorkoutPlanDAO dao;

    public WorkoutPlanService(WorkoutPlanDAO dao) {
        this.dao = dao;
    }

    public WorkoutPlan getWorkout(int id) {
        WorkoutPlan w = dao.findById(id);
        if (w == null)
            throw new ResourceNotFoundException("Workout not found");
        return w;
    }

    public void createWorkout(WorkoutPlan w) {
        dao.save(w);
    }

    public void updateWorkout(WorkoutPlan w) {
        if (dao.findById(w.getId()) == null)
            throw new ResourceNotFoundException("Workout not found");
        dao.update(w);
    }

    public void deleteWorkout(int id) {
        if (dao.findById(id) == null)
            throw new ResourceNotFoundException("Workout not found");
        dao.delete(id);
    }
}




