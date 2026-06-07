package com.zoo.dao;

import com.zoo.config.ConnectionManager;
import com.zoo.model.MedicalProcedure;

import java.sql.*;
import java.util.*;

public class MedicalProcedureDao {

    public List<MedicalProcedure> findAll() {

        List<MedicalProcedure> list = new ArrayList<>();

        String sql = "SELECT * FROM zoo_management.medical_procedure";

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new MedicalProcedure(
                        rs.getInt("procedure_id"),
                        rs.getInt("animal_id"),
                        (Integer) rs.getObject("veterinarian_id"),
                        rs.getString("name"),
                        rs.getTimestamp("start_datetime").toLocalDateTime(),
                        rs.getTimestamp("end_datetime").toLocalDateTime(),
                        rs.getString("medical_report")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public int insert(MedicalProcedure m) {

        String sql = """
                INSERT INTO zoo_management.medical_procedure
                (animal_id, veterinarian_id, name, start_datetime, end_datetime, medical_report)
                VALUES (?, ?, ?, ?, ?, ?)
                RETURNING procedure_id
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, m.getAnimalId());
            ps.setObject(2, m.getVeterinarianId());
            ps.setString(3, m.getName());
            ps.setTimestamp(4, Timestamp.valueOf(m.getStartDatetime()));
            ps.setTimestamp(5, Timestamp.valueOf(m.getEndDatetime()));
            ps.setString(6, m.getMedicalReport());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM zoo_management.medical_procedure WHERE procedure_id=?";

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}