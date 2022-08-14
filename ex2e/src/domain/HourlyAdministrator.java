package domain;

import exceptions.TimeCardIllegalArgumentException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HourlyAdministrator extends Administrator implements JSONStringifiable {
	private double hourlyRate;
	private ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();

	public HourlyAdministrator(int personId, String firstName, String lastName, String userName,
            LocalDateTime birthDate, String ssn, String phone, LocalDateTime employmentStartDate, double hourlyRate) {
        super(personId, firstName, lastName, userName,
                birthDate, ssn, phone, employmentStartDate);
	}

	public void addTimeCard(LocalDateTime startDateTime, LocalDateTime endDateTime) { }

	public void addTimeCard(int id, LocalDateTime startDateTime, LocalDateTime endDateTime) { }

	public TimeCard removeTimeCard(int index) {
		return null;
	}

	public TimeCard getTimeCard(int index) {
        return null;
	}

	public ArrayList<TimeCard> getTimeCards() {
	    return timeCards;
	}

    @Override
    public String toString() {
        return "";
    }

	public double calcTotalHours() {
	    return 0.0;
    }

    @Override
    public double calcGrossPay() {
		return this.calcTotalHours() * this.hourlyRate;
	}

	public String jsonStringify() {
		StringBuilder sb = new StringBuilder(200);

		return sb.toString();
	}
}