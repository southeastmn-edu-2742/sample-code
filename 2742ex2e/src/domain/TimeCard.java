package domain;

import exceptions.TimeCardIllegalArgumentException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TimeCard implements JSONStringifiable {
	private int timeCardId;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;

	public TimeCard(LocalDateTime startDateTime, LocalDateTime endDateTime) { }

	public TimeCard(int timeCardId, LocalDateTime startDateTime, LocalDateTime endDateTime) { }

    public TimeCard(TimeCard timeCard) { }

	public TimeCard copy() {
	    return null;
    }

	public double calcHours() {
		return 0.0;
	}

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeCardId, startDateTime, endDateTime);
    }

    public String jsonStringify() {
	    StringBuilder sb = new StringBuilder(200);

	    return sb.toString();
    }
}