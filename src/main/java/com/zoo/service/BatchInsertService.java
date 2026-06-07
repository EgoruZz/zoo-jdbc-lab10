package com.zoo.service;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchInsertService {

    public static void run() {

        String sql = """
                INSERT INTO zoo_management.animal
                (health_features, species, natural_zone, age, history, volunteer_id)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            long start = System.currentTimeMillis();

            for (int i = 0; i < 15; i++) {

                ps.setString(1, "batch health " + i);
                ps.setString(2, "species " + i);
                ps.setString(3, "zone " + i);
                ps.setInt(4, 1 + i);
                ps.setString(5, "history " + i);
                ps.setInt(6, 3);

                ps.addBatch();
            }

            ps.executeBatch();
            conn.commit();

            long end = System.currentTimeMillis();

            System.out.println("Batch insert time: " + (end - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}