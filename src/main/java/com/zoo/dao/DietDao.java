package com.zoo.dao;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DietDao {

    public void insert(int animalId, String products, String vitamins) {

        String sql = """
                INSERT INTO zoo_management.diet(animal_id, products, vitamins)
                VALUES (?, ?, ?)
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, animalId);
            ps.setString(2, products);
            ps.setString(3, vitamins);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}