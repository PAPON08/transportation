package com.iiuc.transportapi.controller;

import com.iiuc.transportapi.model.Bus;
import com.iiuc.transportapi.service.BusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus createdBus = busService.add(bus);
        return ResponseEntity.ok(createdBus);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        return ResponseEntity.ok(busService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBusById(@PathVariable Long id) {
        Bus bus = busService.getById(id);
        if (bus == null) {
            return ResponseEntity.status(404).body("Bus not found for id: " + id);
        }
        return ResponseEntity.ok(bus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        Bus updatedBus = busService.update(id, bus);
        if (updatedBus == null) {
            return ResponseEntity.status(404).body("Bus not found for id: " + id);
        }
        return ResponseEntity.ok(updatedBus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long id) {
        boolean deleted = busService.delete(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("Bus not found for id: " + id);
        }
        return ResponseEntity.ok("Bus deleted successfully for id: " + id);
    }
}
