package com.iiuc.transportapi.service;

import com.iiuc.transportapi.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    private final List<Schedule> schedules = new ArrayList<>();
    private Long nextId = 100L;

    public Schedule add(Schedule schedule) {
        schedule.setId(nextId++);
        schedules.add(schedule);
        return schedule;
    }

    public List<Schedule> getAll() {
        return new ArrayList<>(schedules);
    }

    public Schedule getById(Long id) {
        return schedules.stream()
                .filter(schedule -> schedule.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Schedule update(Long id, Schedule scheduleData) {
        Schedule existingSchedule = getById(id);
        if (existingSchedule == null) {
            return null;
        }
        existingSchedule.setBusId(scheduleData.getBusId());
        existingSchedule.setRouteId(scheduleData.getRouteId());
        existingSchedule.setDriverId(scheduleData.getDriverId());
        existingSchedule.setDepartureTime(scheduleData.getDepartureTime());
        return existingSchedule;
    }

    public boolean delete(Long id) {
        return schedules.removeIf(schedule -> schedule.getId().equals(id));
    }
}
