package com.example.fitness.model;

public class WorkoutPlan {

    private int id;
    private String type;
    private int duration; // minutes

    public WorkoutPlan() {}

    public WorkoutPlan(int id, String type, int duration) {
        this.id = id;
        this.type = type;
        this.duration = duration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}

