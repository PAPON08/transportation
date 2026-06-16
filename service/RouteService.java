package com.iiuc.transportapi.service;

import com.iiuc.transportapi.model.Route;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {
    private final List<Route> routes = new ArrayList<>();
    private Long nextId = 100L;

    public Route add(Route route) {
        route.setId(nextId++);
        routes.add(route);
        return route;
    }

    public List<Route> getAll() {
        return new ArrayList<>(routes);
    }

    public Route getById(Long id) {
        return routes.stream()
                .filter(route -> route.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Route update(Long id, Route routeData) {
        Route existingRoute = getById(id);
        if (existingRoute == null) {
            return null;
        }
        existingRoute.setRouteName(routeData.getRouteName());
        existingRoute.setPickupPoint(routeData.getPickupPoint());
        existingRoute.setDestination(routeData.getDestination());
        return existingRoute;
    }

    public boolean delete(Long id) {
        return routes.removeIf(route -> route.getId().equals(id));
    }
}
