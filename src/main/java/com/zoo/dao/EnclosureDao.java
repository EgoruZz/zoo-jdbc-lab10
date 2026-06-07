package com.zoo.dao;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnclosureDao {

    public void insert(int animalId, double temp, double humidity) {

        String sql = """
                INSERT INTO zoo_management.enclosure(animal_id, temperature, humidity)
                VALUES (?, ?, ?)
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, animalId);
            ps.setDouble(2, temp);
            ps.setDouble(3, humidity);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}