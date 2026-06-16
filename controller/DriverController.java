package com.iiuc.transportapi.controller;

import com.iiuc.transportapi.model.Driver;
import com.iiuc.transportapi.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver createdDriver = driverService.add(driver);
        return ResponseEntity.ok(createdDriver);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable Long id) {
        Driver driver = driverService.getById(id);
        if (driver == null) {
            return ResponseEntity.status(404).body("Driver not found for id: " + id);
        }
        return ResponseEntity.ok(driver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver updatedDriver = driverService.update(id, driver);
        if (updatedDriver == null) {
            return ResponseEntity.status(404).body("Driver not found for id: " + id);
        }
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable Long id) {
        boolean deleted = driverService.delete(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("Driver not found for id: " + id);
        }
        return ResponseEntity.ok("Driver deleted successfully for id: " + id);
    }
}
