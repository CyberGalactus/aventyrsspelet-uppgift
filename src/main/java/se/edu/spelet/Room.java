package se.edu.spelet;

import java.util.Scanner;

public class Room {

    private String name;
    private String description;
    private String objects;
    private boolean fryingPanFound;

    private Room north = null;
    private Room east = null;
    private Room west = null;
    private Room south = null;
    private Room central = null;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.fryingPanFound = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    public boolean isFryingPanFound() {
        return fryingPanFound;
    }

    public void setFryingPanFound(boolean fryingPanFound) {
        this.fryingPanFound = fryingPanFound;
    }

    public Room getCentral() {
        return central;
    }

    public void setCentral(Room central) {
        this.central = central;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }
}