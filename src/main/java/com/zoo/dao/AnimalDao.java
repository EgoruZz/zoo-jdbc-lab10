package com.zoo.dao;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnimalDao {

    public int countAnimals() {

        String sql =
                "SELECT COUNT(*) FROM zoo_management.animal";

        try (
                Connection c =
                        ConnectionManager.getDataSource().getConnection();

                PreparedStatement ps =
                        c.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            rs.next();

            return rs.getInt(1);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public void insertDemoAnimal() {

        String sql =
                """
                INSERT INTO zoo_management.animal
                (health_features,
                 species,
                 natural_zone,
                 age,
                 history,
                 volunteer_id)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection c =
                        ConnectionManager.getDataSource().getConnection();

                PreparedStatement ps =
                        c.prepareStatement(sql)
        ) {

            ps.setString(1, "healthy");
            ps.setString(2, "demo tiger");
            ps.setString(3, "asia");
            ps.setInt(4, 5);
            ps.setString(5, "jdbc demo");

            ps.setInt(6, 3);

            ps.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}