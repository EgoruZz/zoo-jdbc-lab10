package com.zoo.model;

public class Animal {

    private int animalId;
    private String healthFeatures;
    private String species;
    private String naturalZone;
    private int age;
    private String history;
    private Integer volunteerId;

    public Animal() {}

    public Animal(int animalId, String healthFeatures, String species,
                  String naturalZone, int age, String history, Integer volunteerId) {
        this.animalId = animalId;
        this.healthFeatures = healthFeatures;
        this.species = species;
        this.naturalZone = naturalZone;
        this.age = age;
        this.history = history;
        this.volunteerId = volunteerId;
    }

    public Animal(String healthFeatures, String species,
                  String naturalZone, int age, String history, Integer volunteerId) {
        this.healthFeatures = healthFeatures;
        this.species = species;
        this.naturalZone = naturalZone;
        this.age = age;
        this.history = history;
        this.volunteerId = volunteerId;
    }

    public int getAnimalId() { return animalId; }
    public void setAnimalId(int animalId) { this.animalId = animalId; }

    public String getHealthFeatures() { return healthFeatures; }
    public void setHealthFeatures(String healthFeatures) { this.healthFeatures = healthFeatures; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getNaturalZone() { return naturalZone; }
    public void setNaturalZone(String naturalZone) { this.naturalZone = naturalZone; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getHistory() { return history; }
    public void setHistory(String history) { this.history = history; }

    public Integer getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Integer volunteerId) { this.volunteerId = volunteerId; }
}