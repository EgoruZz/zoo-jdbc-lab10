package com.zoo.service;

import com.zoo.dao.AnimalDao;

public class CrudDemoService {

    private final AnimalDao animalDao =
            new AnimalDao();

    public void run() {

        System.out.println("=== CRUD DEMO ===");

        int before =
                animalDao.countAnimals();

        System.out.println(
                "Animals before = " + before
        );

        animalDao.insertDemoAnimal();

        int after =
                animalDao.countAnimals();

        System.out.println(
                "Animals after = " + after
        );

        System.out.println("CRUD DONE");
    }
}