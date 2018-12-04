package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HourlyAdministratorTest {
    HourlyAdministrator hourlyAdmin;

    // initialize this.hourlyAdmin
    @BeforeEach
    void setUp() {
        this.hourlyAdmin = new HourlyAdministrator(
                105, "Eeee", "Eeeee", "eeee.eeeee",
                LocalDateTime.of(2000, 1, 1, 0, 0, 0),
                "555-55-5555", "555-555-5555",
                LocalDateTime.of(2000, 1, 1, 0, 0, 0),
                50.00);
    }

    // this.hourlyAdmin.addTimeCard(...)
    // retrieve using getTimeCard()
    // use indexOf() and substring() to test string starting at "startDateTime"
    // assertEquals(...)
    @Test
    void addTimeCard() {
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        TimeCard timeCard = this.hourlyAdmin.getTimeCard(0);
        String strTimeCard = timeCard.toString();
        int i = strTimeCard.indexOf("startDateTime");
        strTimeCard = strTimeCard.substring(i);
        assertEquals(
                "startDateTime=2018/10/22 08:00AM, endDateTime=2018/10/22 06:00PM, hours=10.00", strTimeCard);
    }

    // attempt to getTimeCard() using invalid index
    // assert return value is null
    // this.hourlyAdmin.addTimeCard(...)
    // use getTimeCard() to retrieve element 0
    // use indexOf() and substring() to test string starting at "startDateTime"
    // assertEquals(...)
    @Test
    void getTimeCard() {
        // attempt get using invalid index
        TimeCard timeCard = this.hourlyAdmin.getTimeCard(0);
        assertEquals(null, timeCard);
        // remove using valid index
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        timeCard = this.hourlyAdmin.getTimeCard(0);
        String strTimeCard = timeCard.toString();
        int i = strTimeCard.indexOf("startDateTime");
        strTimeCard = strTimeCard.substring(i);
        assertEquals(
                "startDateTime=2018/10/22 08:00AM, endDateTime=2018/10/22 06:00PM, hours=10.00", strTimeCard);
    }

    // attempt to removeTimeCard() using invalid index
    // assert return value is null
    // this.hourlyAdmin.addTimeCard(...)
    // use removeTimeCard() to retrieve element 0
    // use indexOf() and substring() to test string starting at "startDateTime"
    // assertEquals(...)
    // retrieve ArrayList<TimeCard> using getTimeCards()
    // test size using AssertEquals(...)
    @Test
    void removeTimeCard() {
        // attempt remove using invalid index
        TimeCard timeCard = this.hourlyAdmin.removeTimeCard(0);
        assertEquals(null, timeCard);
        // remove using valid index
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        timeCard = this.hourlyAdmin.removeTimeCard(0);
        String strTimeCard = timeCard.toString();
        int i = strTimeCard.indexOf("startDateTime");
        strTimeCard = strTimeCard.substring(i);
        assertEquals(
                "startDateTime=2018/10/22 08:00AM, endDateTime=2018/10/22 06:00PM, hours=10.00", strTimeCard);
        // ensure TimeCard has been removed
        ArrayList<TimeCard> timeCards = this.hourlyAdmin.getTimeCards();
        assertEquals(0, timeCards.size());
    }

    // add several TimeCards using addTimeCard(...)
    // this.hourAdmin.getTimeCards()
    // for each TimeCard in ArrayList
    //      assertEquals(this.hourlyAdmin.getTimeCard(...), TimeCard from ArrayList
    //      assert this.hourlyAdmin.getTimeCard(...) is a copy of TimeCard from ArrayList
    @Test
    void getTimeCards() {
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 23, 8, 0),
                LocalDateTime.of(2018, 10, 23, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 24, 8, 0),
                LocalDateTime.of(2018, 10, 24, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 25, 8, 0),
                LocalDateTime.of(2018, 10, 25, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 26, 8, 0),
                LocalDateTime.of(2018, 10, 26, 18, 0));

        ArrayList<TimeCard> timeCards = this.hourlyAdmin.getTimeCards();

        for (int i = 0; i < timeCards.size(); i++) {
            assertEquals(this.hourlyAdmin.getTimeCard(i), timeCards.get(i));
            // ensure getTimeCards() returned copies of TimeCards
            assertFalse(this.hourlyAdmin.getTimeCard(i) == timeCards.get(i));
        }
    }

    @Test
    void toStringTest() {
        String result = "105 Eeeee, Eeee, birthDate=2000/01/01, ssn='555-55-5555', phone='555-555-5555', employmentStartDate=2000/01/01, hourlyRate=50.0, totalHours=0.00, grossPay=0.00";
        assertEquals(result, this.hourlyAdmin.toString());
    }

    @Test
    void calcTotalHours() {
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 23, 8, 0),
                LocalDateTime.of(2018, 10, 23, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 24, 8, 0),
                LocalDateTime.of(2018, 10, 24, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 25, 8, 0),
                LocalDateTime.of(2018, 10, 25, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 26, 8, 0),
                LocalDateTime.of(2018, 10, 26, 18, 0));

        assertEquals(50.0, this.hourlyAdmin.calcTotalHours());
    }

    @Test
    void calcGrossPay() {
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 23, 8, 0),
                LocalDateTime.of(2018, 10, 23, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 24, 8, 0),
                LocalDateTime.of(2018, 10, 24, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 25, 8, 0),
                LocalDateTime.of(2018, 10, 25, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 26, 8, 0),
                LocalDateTime.of(2018, 10, 26, 18, 0));

        assertEquals(2500.0, this.hourlyAdmin.calcGrossPay());
    }

    @Test
    void jsonStringifyTest() {
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 22, 8, 0),
                LocalDateTime.of(2018, 10, 22, 18, 0));
        this.hourlyAdmin.addTimeCard(LocalDateTime.of(2018, 10, 23, 8, 0),
                LocalDateTime.of(2018, 10, 23, 18, 0));

        assertEquals("{\n" +
                "\"subclass\":\"hourlyAdministrator\",\n" +
                "\"personId\":105,\n" +
                "\"lastName\":\"Eeeee\",\n" +
                "\"firstName\":\"Eeee\",\n" +
                "\"userName\":\"eeee.eeeee\",\n" +
                "\"birthDate\":\"2000/01/01\",\n" +
                "\"ssn\":\"555-55-5555\",\n" +
                "\"phone\":\"555-555-5555\",\n" +
                "\"employmentStartDate\":\"2000/01/01\",\n" +
                "\"hourlyRate\":50.0,\n" +
                "\"timeCards\":[\n" +
                "{\"id\":10001,\"startDateTime\":\"2018/10/22 08:00AM\",\"endDateTime\":\"2018/10/22 06:00PM\"},\n" +
                "{\"id\":10002,\"startDateTime\":\"2018/10/23 08:00AM\",\"endDateTime\":\"2018/10/23 06:00PM\"}\n" +
                "]\n" +
                "}", this.hourlyAdmin.jsonStringify());
    }
}