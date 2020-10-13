package com.looptrace.planetary.models;

public class Planet {

    private String id;
    private String name;
    private String sun_distance;
    private String date_discovered;
    private String discovered_by;

    public Planet(String id, String name, String sun_distance, String date_discovered, String discovered_by) {
        this.id = id;
        this.name = name;
        this.sun_distance = sun_distance;
        this.date_discovered = date_discovered;
        this.discovered_by = discovered_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSun_distance() {
        return sun_distance;
    }

    public void setSun_distance(String sun_distance) {
        this.sun_distance = sun_distance;
    }

    public String getDate_discovered() {
        return date_discovered;
    }

    public void setDate_discovered(String date_discovered) {
        this.date_discovered = date_discovered;
    }

    public String getDiscovered_by() {
        return discovered_by;
    }

    public void setDiscovered_by(String discovered_by) {
        this.discovered_by = discovered_by;
    }
}
