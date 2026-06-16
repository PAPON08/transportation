package com.iiuc.transportapi.model;

public class Driver {
    private Long id;
    private String driverName;
    private String phoneNumber;
    private String licenseNumber;

    public Driver() {
    }

    public Driver(Long id, String driverName, String phoneNumber, String licenseNumber) {
        this.id = id;
        this.driverName = driverName;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
