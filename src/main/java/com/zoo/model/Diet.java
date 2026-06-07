package com.zoo.model;

public class Diet {

    private int animalId;
    private String products;
    private String vitamins;

    public Diet() {}

    public Diet(int animalId, String products, String vitamins) {
        this.animalId = animalId;
        this.products = products;
        this.vitamins = vitamins;
    }

    public int getAnimalId() { return animalId; }
    public void setAnimalId(int animalId) { this.animalId = animalId; }

    public String getProducts() { return products; }
    public void setProducts(String products) { this.products = products; }

    public String getVitamins() { return vitamins; }
    public void setVitamins(String vitamins) { this.vitamins = vitamins; }
}