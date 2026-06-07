package com.zoo.dao;

import com.zoo.config.ConnectionManager;
import com.zoo.model.Volunteer;

import java.sql.*;
import java.util.*;

public class VolunteerDao {

    public List<Volunteer> findAll() {

        List<Volunteer> list = new ArrayList<>();

        String sql = "SELECT * FROM zoo_management.volunteer";

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Volunteer(
                        rs.getInt("volunteer_id"),
                        rs.getString("full_name"),
                        rs.getString("specialization")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public int insert(Volunteer v) {

        String sql = """
                INSERT INTO zoo_management.volunteer(full_name, specialization)
                VALUES (?, ?) RETURNING volunteer_id
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, v.getFullName());
            ps.setString(2, v.getSpecialization());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM zoo_management.volunteer WHERE volunteer_id=?";

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}