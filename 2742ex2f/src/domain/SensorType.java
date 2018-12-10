package domain;

import java.util.ArrayList;
import java.util.Objects;

public class SensorType {
    private int sensorTypeId;
    private String sensorTypeName;
    private ArrayList<Sensor> sensors;

    public SensorType(int sensorTypeId, String sensorTypeName) {
        this.sensorTypeId = sensorTypeId;
        this.sensorTypeName = sensorTypeName;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getSensorTypeName() {
        return sensorTypeName;
    }

    public void setSensorTypeName(String sensorTypeName) {
        this.sensorTypeName = sensorTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SensorType)) return false;
        SensorType that = (SensorType) o;
        return sensorTypeId == that.sensorTypeId &&
                Objects.equals(sensorTypeName, that.sensorTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorTypeId, sensorTypeName);
    }

    @Override
    public String toString() {
        return Integer.toString(sensorTypeId) +
                " " + sensorTypeName;
    }
}
