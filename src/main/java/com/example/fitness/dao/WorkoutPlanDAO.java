package com.example.fitness.dao;

import com.example.fitness.model.WorkoutPlan;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class WorkoutPlanDAO {

    private final String URL = "jdbc:postgresql://localhost:5432/fitness_oop_db";
    private final String USER = "postgres";
    private final String PASSWORD = "12345678";

    public void save(WorkoutPlan w) {
        String sql = "INSERT INTO workout_plans VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, w.getId());
            ps.setString(2, w.getType());
            ps.setInt(3, w.getDuration());
            ps.setInt(4, w.getUserId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WorkoutPlan findById(int id) {
        String sql = "SELECT * FROM workout_plans WHERE id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new WorkoutPlan(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getInt("duration"),
                        rs.getInt("user_id")
                );
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(WorkoutPlan w) {
        String sql = "UPDATE workout_plans SET type=?, duration=?, user_id=? WHERE id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, w.getType());
            ps.setInt(2, w.getDuration());
            ps.setInt(3, w.getUserId());
            ps.setInt(4, w.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM workout_plans WHERE id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



