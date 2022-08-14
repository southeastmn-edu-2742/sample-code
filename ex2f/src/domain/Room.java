package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Room {
    private int roomId;
    private String roomName;
    private int buildingId;
    private Building building;
    private ArrayList<Sensor> Sensors = new ArrayList<Sensor>();

    public Room(int roomId, String roomName, int buildingId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.buildingId = buildingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomId == room.roomId &&
                buildingId == room.buildingId &&
                Objects.equals(roomName, room.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomName, buildingId);
    }

    @Override
    public String toString() {
        return Integer.toString(roomId) +
                ", " + roomName +
                ", buildingId=" + buildingId;
    }
}
