package com.zoo.model;

import java.time.LocalTime;

public class DutySchedule {

    private int scheduleId;
    private int volunteerId;
    private int dayOfWeek;
    private LocalTime startTime;
    private String shiftDuration;

    public DutySchedule() {}

    public DutySchedule(int scheduleId, int volunteerId, int dayOfWeek, LocalTime startTime, String shiftDuration) {
        this.scheduleId = scheduleId;
        this.volunteerId = volunteerId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.shiftDuration = shiftDuration;
    }

    public int getScheduleId() { return scheduleId; }
    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }

    public int getVolunteerId() { return volunteerId; }
    public void setVolunteerId(int volunteerId) { this.volunteerId = volunteerId; }

    public int getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(int dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public String getShiftDuration() { return shiftDuration; }
    public void setShiftDuration(String shiftDuration) { this.shiftDuration = shiftDuration; }
}