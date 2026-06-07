package com.zoo.service;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionService {

    public static void run() {

        String sql = """
                INSERT INTO zoo_management.animal
                (health_features, species, natural_zone, age, history, volunteer_id)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            ps.setString(1, "tx1");
            ps.setString(2, "lion");
            ps.setString(3, "savanna");
            ps.setInt(4, 5);
            ps.setString(5, "tx test");
            ps.setObject(6, 3);
            ps.executeUpdate();

            // искусственная ошибка
            if (true) throw new RuntimeException("rollback test");

            ps.setString(1, "tx2");
            ps.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            System.out.println("Rollback executed");
        }
    }
}