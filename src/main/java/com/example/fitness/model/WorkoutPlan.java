package com.example.fitness.model;

public class WorkoutPlan {

    private int id;
    private String type;
    private int duration;
    private int userId;

    public WorkoutPlan() {}

    public WorkoutPlan(int id, String type, int duration, int userId) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.userId = userId;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public int getDuration() { return duration; }
    public int getUserId() { return userId; }

    public void setId(int id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setUserId(int userId) { this.userId = userId; }
}

