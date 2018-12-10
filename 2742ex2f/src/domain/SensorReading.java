package domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class SensorReading {
    private int sensorReadingId;
    private int sensorId;
    private LocalDateTime dateTime;
    private float value;
    private Sensor sensor;

    public SensorReading(int sensorReadingId, int sensorId, LocalDateTime dateTime, float value) {
        this.sensorReadingId = sensorReadingId;
        this.sensorId = sensorId;
        this.dateTime = dateTime;
        this.value = value;
    }

    public int getSensorReadingId() {
        return sensorReadingId;
    }

    public void setSensorReadingId(int sensorReadingId) {
        this.sensorReadingId = sensorReadingId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SensorReading)) return false;
        SensorReading that = (SensorReading) o;
        return sensorReadingId == that.sensorReadingId &&
                sensorId == that.sensorId &&
                Float.compare(that.value, value) == 0 &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorReadingId, sensorId, dateTime, value);
    }

    @Override
    public String toString() {
        return "id=" + sensorReadingId +
                ", sensorId=" + sensorId +
                ", dateTime=" + dateTime +
                ", value=" + value;
    }
}
