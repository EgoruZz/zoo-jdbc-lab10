package com.zoo.dao;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DutyScheduleDao {

    public void insert(int volunteerId, int day, String startTime, String duration) {

        String sql = """
                INSERT INTO zoo_management.duty_schedule(volunteer_id, day_of_week, start_time, shift_duration)
                VALUES (?, ?, ?::time, ?::interval)
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, volunteerId);
            ps.setInt(2, day);
            ps.setString(3, startTime);
            ps.setString(4, duration);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}