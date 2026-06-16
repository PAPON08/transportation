package com.iiuc.transportapi.model;

public class Route {
    private Long id;
    private String routeName;
    private String pickupPoint;
    private String destination;

    public Route() {
    }

    public Route(Long id, String routeName, String pickupPoint, String destination) {
        this.id = id;
        this.routeName = routeName;
        this.pickupPoint = pickupPoint;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
