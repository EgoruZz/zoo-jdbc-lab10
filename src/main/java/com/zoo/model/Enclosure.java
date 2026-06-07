package com.zoo.model;

public class Enclosure {

    private int animalId;
    private double temperature;
    private double humidity;

    public Enclosure() {}

    public Enclosure(int animalId, double temperature, double humidity) {
        this.animalId = animalId;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public int getAnimalId() { return animalId; }
    public void setAnimalId(int animalId) { this.animalId = animalId; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }
}