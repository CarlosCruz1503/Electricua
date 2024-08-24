package com.example.panelcontrol.Modelos;

public class Plantation {
    private float cost;
    private String month;

    private String zone;
    private Integer floors;

    public Plantation(float cost, String month, String zone, Integer floors) {
        this.cost = cost;
        this.month = month;
        this.zone = zone;
        this.floors = floors;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setZone(Integer floors) {
        this.floors = floors;
    }
    @Override
    public String toString() {
        return "Plantation{" +
                "cost=" + cost +
                ", month='" + month + '\'' +
                ", zone='" + zone + '\'' +
                ", floors=" + floors +
                '}';
    }
}

