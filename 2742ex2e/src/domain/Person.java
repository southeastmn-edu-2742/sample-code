package domain;

import exceptions.PersonIllegalArgumentException;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private int personId;
    protected String firstName;
    private String lastName;
    private String userName;
    private LocalDateTime updated;

    public Person() { }

    public Person(int personId, String firstName, String lastName, String userName) {  }

    public int getPersonId()                    { return this.personId; }
    public String getFirstName()                { return this.firstName; }
    public String getLastName()                 { return lastName; }
    public String getUserName()                 { return userName; }
    public void setUpdated()                    { this.updated = LocalDateTime.now(); }
    public LocalDateTime getUpdated()           { return updated; }

    public void setPersonId(int personId) { }

    public void setFirstName(String firstName) { }

    public void setLastName(String lastName) { }

    public void setUserName(String userName){ }

    @Override
    public String toString() {
        return "";
    }

    public String toShortString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}