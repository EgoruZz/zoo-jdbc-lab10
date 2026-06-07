package com.zoo.model;

import java.time.LocalDateTime;

public class MedicalProcedure {

    private int procedureId;
    private int animalId;
    private Integer veterinarianId;
    private String name;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private String medicalReport;

    public MedicalProcedure() {}

    public MedicalProcedure(int procedureId, int animalId, Integer veterinarianId,
                            String name, LocalDateTime startDatetime,
                            LocalDateTime endDatetime, String medicalReport) {
        this.procedureId = procedureId;
        this.animalId = animalId;
        this.veterinarianId = veterinarianId;
        this.name = name;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.medicalReport = medicalReport;
    }

    public int getProcedureId() { return procedureId; }
    public void setProcedureId(int procedureId) { this.procedureId = procedureId; }

    public int getAnimalId() { return animalId; }
    public void setAnimalId(int animalId) { this.animalId = animalId; }

    public Integer getVeterinarianId() { return veterinarianId; }
    public void setVeterinarianId(Integer veterinarianId) { this.veterinarianId = veterinarianId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getStartDatetime() { return startDatetime; }
    public void setStartDatetime(LocalDateTime startDatetime) { this.startDatetime = startDatetime; }

    public LocalDateTime getEndDatetime() { return endDatetime; }
    public void setEndDatetime(LocalDateTime endDatetime) { this.endDatetime = endDatetime; }

    public String getMedicalReport() { return medicalReport; }
    public void setMedicalReport(String medicalReport) { this.medicalReport = medicalReport; }
}