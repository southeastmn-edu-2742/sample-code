package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Administrator extends Person {
	private LocalDateTime birthDate;
	private String ssn;
	private String phone;
	private LocalDateTime employmentStartDate;

	public Administrator(int personId, String firstName, String lastName, String userName,
                         LocalDateTime birthDate, String ssn, String phone, LocalDateTime employmentStartDate) {
	    super(personId, firstName, lastName, userName);
	}


    @Override
    public String toString() {
        return "";
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(LocalDateTime employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public abstract double calcGrossPay();
}