package com.zoo.service;

import com.zoo.config.ConnectionManager;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class BusinessQueryService {

    public static void run() {

        String sql =
                """
                SELECT v.full_name, COUNT(a.animal_id) AS animals
                FROM zoo_management.volunteer v
                LEFT JOIN zoo_management.animal a
                ON v.volunteer_id = a.volunteer_id
                GROUP BY v.full_name
                """;

        try (Connection c = ConnectionManager.getDataSource().getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString(1) + " -> " + rs.getInt(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}