package domain;

import java.time.LocalDateTime;

public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDateTime updated;

    public Person() {
        this.personId = 0;
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.updated = LocalDateTime.now();
    }
    public Person(int personId, String firstName, String lastName, String userName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.updated = LocalDateTime.now();
    }

    public int getPersonId()                    { return this.personId; }
    public String getFirstName()                { return this.firstName; }
    public String getLastName()                 { return lastName; }
    public String getUserName()                 { return userName; }
    public void setUpdated()                    { this.updated = LocalDateTime.now(); }
    public LocalDateTime getUpdated()           { return updated; }

    public String setPersonId(int personId) {
        String errMsg = "";
        if (personId >= 101 && personId <= 999)
            this.personId = personId;
        else
            errMsg = Integer.toString(personId) + " is invalid. PersonId must be >= 101 and <= 999";

        return errMsg;
    }

    public String setFirstName(String firstName) {
        String errMsg = "";
        if (firstName != null && firstName.length() > 2 && firstName.length() <= 15)
            this.firstName = firstName;
        else
            errMsg = firstName + " is invalid. First name must be > 2 and <= 15 characters";

        return errMsg;
    }

    public String setLastName(String lastName) {
        String errMsg = "";
        if (lastName != null && lastName.length() >= 2 && lastName.length() <= 30) {
            this.lastName = lastName;
        }
        else
            errMsg = lastName + " is invalid. Last name must be between 2 and 30 characters";

        return errMsg;
    }

    public String setUserName(String userName){
        String errMsg = "";
        if (userName!= null && userName.length() >= 5 && userName.length() <= 30) {
            switch (userName.toLowerCase()) {
                case "admin":
                case "administrator":
                case "supervisor":
                    errMsg = userName + " is invalid. Admin user names not allowed";
                    break;
                default:
                    this.userName = userName;
                    break;
            }
        }
        else
            errMsg = userName + " is invalid. User name must be between 5 and 30 characters";

        return errMsg;
    }
}
