package com.iiuc.transportapi.controller;

import com.iiuc.transportapi.model.Schedule;
import com.iiuc.transportapi.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = scheduleService.add(schedule);
        return ResponseEntity.ok(createdSchedule);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScheduleById(@PathVariable Long id) {
        Schedule schedule = scheduleService.getById(id);
        if (schedule == null) {
            return ResponseEntity.status(404).body("Schedule not found for id: " + id);
        }
        return ResponseEntity.ok(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        Schedule updatedSchedule = scheduleService.update(id, schedule);
        if (updatedSchedule == null) {
            return ResponseEntity.status(404).body("Schedule not found for id: " + id);
        }
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        boolean deleted = scheduleService.delete(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("Schedule not found for id: " + id);
        }
        return ResponseEntity.ok("Schedule deleted successfully for id: " + id);
    }
}
