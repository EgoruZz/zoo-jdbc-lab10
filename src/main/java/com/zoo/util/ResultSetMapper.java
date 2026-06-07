package com.zoo.util;

import com.zoo.model.Animal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetMapper {

    public static Animal mapAnimal(ResultSet rs) throws SQLException {
        return new Animal(
                rs.getInt("animal_id"),
                rs.getString("health_features"),
                rs.getString("species"),
                rs.getString("natural_zone"),
                rs.getInt("age"),
                rs.getString("history"),
                (Integer) rs.getObject("volunteer_id")
        );
    }
}