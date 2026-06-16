package com.iiuc.transportapi.service;

import com.iiuc.transportapi.model.Driver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    private final List<Driver> drivers = new ArrayList<>();
    private Long nextId = 100L;

    public Driver add(Driver driver) {
        driver.setId(nextId++);
        drivers.add(driver);
        return driver;
    }

    public List<Driver> getAll() {
        return new ArrayList<>(drivers);
    }

    public Driver getById(Long id) {
        return drivers.stream()
                .filter(driver -> driver.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Driver update(Long id, Driver driverData) {
        Driver existingDriver = getById(id);
        if (existingDriver == null) {
            return null;
        }
        existingDriver.setDriverName(driverData.getDriverName());
        existingDriver.setPhoneNumber(driverData.getPhoneNumber());
        existingDriver.setLicenseNumber(driverData.getLicenseNumber());
        return existingDriver;
    }

    public boolean delete(Long id) {
        return drivers.removeIf(driver -> driver.getId().equals(id));
    }
}
