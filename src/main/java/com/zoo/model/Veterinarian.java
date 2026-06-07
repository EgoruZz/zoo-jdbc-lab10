package com.zoo.model;

public class Veterinarian {

    private int veterinarianId;
    private String fullName;

    public Veterinarian() {}

    public Veterinarian(int veterinarianId, String fullName) {
        this.veterinarianId = veterinarianId;
        this.fullName = fullName;
    }

    public Veterinarian(String fullName) {
        this.fullName = fullName;
    }

    public int getVeterinarianId() { return veterinarianId; }
    public void setVeterinarianId(int veterinarianId) { this.veterinarianId = veterinarianId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}