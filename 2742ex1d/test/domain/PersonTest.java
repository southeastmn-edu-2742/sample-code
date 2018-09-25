package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person = null;

    @BeforeEach
    void setUp() {
        this.person = new Person();
    }

    @Test
    void setPersonIdBelowRange() {
        assertNotEquals(this.person.setPersonId(100), "");
    }

    @Test
    void setPersonIdMinimum() {
        assertEquals(this.person.setPersonId(101), "");
    }

    @Test
    void setPersonIdMaximum() {
        assertEquals(this.person.setPersonId(999), "");
    }

    @Test
    void setPersonIdAboveRange() {
        assertNotEquals(this.person.setPersonId(1000), "");
    }

    @Test
    void setFirstNameNull() {
        assertNotEquals(this.person.setFirstName(null), "");
    }

    @Test
    void setFirstNameBelowMinimum() {
        assertNotEquals(this.person.setFirstName("Aa"), "");
    }

    @Test
    void setFirstNameMinimum() {
        assertEquals(this.person.setFirstName("Aaa"), "");
    }

    @Test
    void setFirstNameMaximum() {
        assertEquals(this.person.setFirstName("Aaaaaaaaaaaaaaa"), "");
    }

    @Test
    void setFirstNameAboveMaximum() {
        assertNotEquals(this.person.setFirstName("Aaaaaaaaaaaaaaaa"), "");
    }

    @Test
    void setLastNameNull() {
        assertNotEquals(this.person.setLastName(null), "");
    }

    @Test
    void setLastNameBelowMinimum() {
        assertNotEquals(this.person.setLastName("A"), "");
    }

    @Test
    void setLastNameMinimum() {
        assertEquals(this.person.setLastName("Aa"), "");
    }

    @Test
    void setLastNameMaximum() {
        assertEquals(this.person.setLastName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), "");
    }

    @Test
    void setLastNameAboveMaximum() {
        assertNotEquals(this.person.setLastName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), "");
    }

    @Test
    void setUserNameNull() {
        assertNotEquals(this.person.setUserName(null), "");
    }

    @Test
    void setUserNameBelowMinimum() {
        assertNotEquals(this.person.setUserName("Aaaa"), "");
    }

    @Test
    void setUserNameMinimum() {
        assertEquals(this.person.setUserName("Aaaaa"), "");
    }

    @Test
    void setUserNameMaximum() {
        assertEquals(this.person.setUserName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), "");
    }

    @Test
    void setUserNameAboveMaximum() {
        assertNotEquals(this.person.setUserName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), "");
    }

    @Test
    void setUserNameAdmin() {
        assertNotEquals(this.person.setUserName("ADMIN"), "");
    }

    @Test
    void setUserNameAdministrator() {
        assertNotEquals(this.person.setUserName("ADMINISTRATOR"), "");
    }

    @Test
    void setUserNameSupervisor() {
        assertNotEquals(this.person.setUserName("SUPERVISOR"), "");
    }
}