package com.iiuc.transportapi.controller;

import com.iiuc.transportapi.model.Route;
import com.iiuc.transportapi.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route createdRoute = routeService.add(route);
        return ResponseEntity.ok(createdRoute);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRouteById(@PathVariable Long id) {
        Route route = routeService.getById(id);
        if (route == null) {
            return ResponseEntity.status(404).body("Route not found for id: " + id);
        }
        return ResponseEntity.ok(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoute(@PathVariable Long id, @RequestBody Route route) {
        Route updatedRoute = routeService.update(id, route);
        if (updatedRoute == null) {
            return ResponseEntity.status(404).body("Route not found for id: " + id);
        }
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        boolean deleted = routeService.delete(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("Route not found for id: " + id);
        }
        return ResponseEntity.ok("Route deleted successfully for id: " + id);
    }
}
