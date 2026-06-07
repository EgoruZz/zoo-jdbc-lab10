package com.zoo.model;

public class Volunteer {

    private int volunteerId;
    private String fullName;
    private String specialization;

    public Volunteer() {}

    public Volunteer(int volunteerId, String fullName, String specialization) {
        this.volunteerId = volunteerId;
        this.fullName = fullName;
        this.specialization = specialization;
    }

    public Volunteer(String fullName, String specialization) {
        this.fullName = fullName;
        this.specialization = specialization;
    }

    public int getVolunteerId() { return volunteerId; }
    public void setVolunteerId(int volunteerId) { this.volunteerId = volunteerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}