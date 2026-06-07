-- часть 1 создание схемы

CREATE SCHEMA IF NOT EXISTS zoo_management;

-- часть 2 создание таблиц

-- 1. Справочники (без внешних ключей)
CREATE TABLE volunteer (
    volunteer_id INT GENERATED ALWAYS AS IDENTITY,
    full_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(50) NOT NULL,
    CONSTRAINT pk_volunteer PRIMARY KEY (volunteer_id)
);

CREATE TABLE veterinarian (
    veterinarian_id INT GENERATED ALWAYS AS IDENTITY,
    full_name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_veterinarian PRIMARY KEY (veterinarian_id)
);

-- 2. Основная сущность (зависит от волонтера)
CREATE TABLE animal (
    animal_id INT GENERATED ALWAYS AS IDENTITY,
    health_features VARCHAR(200),
    species VARCHAR(50) NOT NULL,
    natural_zone VARCHAR(50) NOT NULL,
    age SMALLINT NOT NULL CHECK (age >= 0),
    history TEXT,
    volunteer_id INT, 
    CONSTRAINT pk_animal PRIMARY KEY (animal_id),
    CONSTRAINT fk_animal_volunteer FOREIGN KEY (volunteer_id) 
        REFERENCES  zoo_management.volunteer(volunteer_id) ON DELETE SET NULL
);

-- 3. Зависимые таблицы и связи 1:1
CREATE TABLE duty_schedule (
    schedule_id INT GENERATED ALWAYS AS IDENTITY,
    volunteer_id INT NOT NULL,
    day_of_week SMALLINT NOT NULL CHECK (day_of_week BETWEEN 1 AND 7),
    start_time TIME NOT NULL,
    shift_duration INTERVAL NOT NULL,
    CONSTRAINT pk_duty_schedule PRIMARY KEY (schedule_id),
    CONSTRAINT fk_schedule_volunteer FOREIGN KEY (volunteer_id) 
        REFERENCES zoo_management.volunteer(volunteer_id) ON DELETE CASCADE
);

CREATE TABLE enclosure (
    animal_id INT NOT NULL,
    temperature NUMERIC(3,1) NOT NULL,
    humidity NUMERIC(3,1) NOT NULL,
    CONSTRAINT pk_enclosure PRIMARY KEY (animal_id),
    CONSTRAINT fk_enclosure_animal FOREIGN KEY (animal_id) 
        REFERENCES zoo_management.animal(animal_id) ON DELETE CASCADE
);

CREATE TABLE diet (
    animal_id INT NOT NULL,
    products VARCHAR(200) NOT NULL,
    vitamins VARCHAR(200) NOT NULL,
    CONSTRAINT pk_diet PRIMARY KEY (animal_id),
    CONSTRAINT fk_diet_animal FOREIGN KEY (animal_id) 
        REFERENCES zoo_management.animal(animal_id) ON DELETE CASCADE
);

CREATE TABLE medical_procedure (
    procedure_id INT GENERATED ALWAYS AS IDENTITY,
    animal_id INT NOT NULL,
    veterinarian_id INT,
    name VARCHAR(50) NOT NULL,
    start_datetime TIMESTAMPTZ NOT NULL,
    end_datetime TIMESTAMPTZ NOT NULL,
    medical_report TEXT NOT NULL,
    CONSTRAINT pk_medical_procedure PRIMARY KEY (procedure_id),
    CONSTRAINT fk_procedure_animal FOREIGN KEY (animal_id) 
        REFERENCES zoo_management.animal(animal_id) ON DELETE CASCADE,
    CONSTRAINT fk_procedure_vet FOREIGN KEY (veterinarian_id) 
        REFERENCES zoo_management.veterinarian(veterinarian_id) ON DELETE SET NULL,
    CONSTRAINT chk_dates CHECK (end_datetime > start_datetime)
);

-- часть 3 удаление таблиц и схемы

/*
DROP TABLE IF EXISTS medical_procedure;
DROP TABLE IF EXISTS diet;
DROP TABLE IF EXISTS enclosure;
DROP TABLE IF EXISTS duty_schedule;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS veterinarian;
DROP TABLE IF EXISTS volunteer;
*/

-- DROP SCHEMA IF EXISTS zoo_management CASCADE;