package com.iiuc.transportapi.service;

import com.iiuc.transportapi.model.Bus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {
    private final List<Bus> buses = new ArrayList<>();
    private Long nextId = 100L;

    public Bus add(Bus bus) {
        bus.setId(nextId++);
        buses.add(bus);
        return bus;
    }

    public List<Bus> getAll() {
        return new ArrayList<>(buses);
    }

    public Bus getById(Long id) {
        return buses.stream()
                .filter(bus -> bus.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Bus update(Long id, Bus busData) {
        Bus existingBus = getById(id);
        if (existingBus == null) {
            return null;
        }
        existingBus.setBusNumber(busData.getBusNumber());
        existingBus.setCapacity(busData.getCapacity());
        existingBus.setSemester(busData.getSemester());
        return existingBus;
    }

    public boolean delete(Long id) {
        return buses.removeIf(bus -> bus.getId().equals(id));
    }
}
