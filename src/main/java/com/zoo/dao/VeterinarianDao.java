package com.zoo.dao;

import com.zoo.config.ConnectionManager;
import com.zoo.model.Veterinarian;

import java.sql.*;
import java.util.*;

public class VeterinarianDao {

    public List<Veterinarian> findAll() {

        List<Veterinarian> list = new ArrayList<>();

        String sql = "SELECT * FROM zoo_management.veterinarian";

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Veterinarian(
                        rs.getInt("veterinarian_id"),
                        rs.getString("full_name")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public int insert(Veterinarian v) {

        String sql = """
                INSERT INTO zoo_management.veterinarian(full_name)
                VALUES (?) RETURNING veterinarian_id
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, v.getFullName());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }
}