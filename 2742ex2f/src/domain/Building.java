package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Building {
    private int buildingId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private ArrayList<Room> rooms;

    public Building(int buildingId, String address, String city, String state, String zip) {
        this.buildingId = buildingId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return Integer.toString(buildingId) +
                ", " + address +
                ", " + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;
        Building building = (Building) o;
        return buildingId == building.buildingId &&
                Objects.equals(address, building.address) &&
                Objects.equals(city, building.city) &&
                Objects.equals(state, building.state) &&
                Objects.equals(zip, building.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingId, address, city, state, zip);
    }
}
