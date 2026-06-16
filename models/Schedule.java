package com.iiuc.transportapi.model;

public class Schedule {
    private Long id;
    private Long busId;
    private Long routeId;
    private Long driverId;
    private String departureTime;

    public Schedule() {
    }

    public Schedule(Long id, Long busId, Long routeId, Long driverId, String departureTime) {
        this.id = id;
        this.busId = busId;
        this.routeId = routeId;
        this.driverId = driverId;
        this.departureTime = departureTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
