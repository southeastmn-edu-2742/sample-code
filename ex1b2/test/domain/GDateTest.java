package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GDateTest {

    GDate date1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.date1 = new GDate();
    }

    @org.junit.jupiter.api.Test
    void equals() {
        GDate date2 = new GDate();
        assertTrue(this.date1.equals(date2));
    }

    @org.junit.jupiter.api.Test
    void notEquals() {
        GDate date2 = new GDate(2000, 1, 2);
        assertFalse(this.date1.equals(date2));
    }

    @org.junit.jupiter.api.Test
    void testYMDConstructor() {
        GDate date2 = new GDate(2000, 1, 1);
        assertTrue(this.date1.equals(date2));
    }

    @org.junit.jupiter.api.Test
    void testCopyConstructor() {
        GDate date2 = new GDate(this.date1);
        assertTrue(this.date1.equals(date2));
    }

    @org.junit.jupiter.api.Test
    void testJulianDayConstructor() {
        GDate date2 = new GDate(2451545);
        assertTrue(this.date1.equals(date2));
    }

    @org.junit.jupiter.api.Test
    void greaterThan() {
        GDate date2 = new GDate(2000, 1, 2);
        assertTrue(date2.greaterThan(this.date1));
    }

    @org.junit.jupiter.api.Test
    void notGreaterThan() {
        GDate date2 = new GDate(2000, 1, 2);
        assertFalse(this.date1.greaterThan(date2));
    }

    @org.junit.jupiter.api.Test
    void diffNonLeapYear() {
        GDate date2 = new GDate(2001, 2, 28);
        GDate date3 = new GDate(2001, 3, 1);
        assertEquals(1, date3.diff(date2));
    }

    @org.junit.jupiter.api.Test
    void diffLeapYear() {
        GDate date2 = new GDate(2000, 2, 28);
        GDate date3 = new GDate(2000, 3, 1);
        assertEquals(2, date3.diff(date2));
    }

    @org.junit.jupiter.api.Test
    void add() {
        GDate date2 = new GDate(2000, 1, 2);
        GDate date3 = this.date1.add(1);
        assertTrue(date2.equals(date3));
    }

    @org.junit.jupiter.api.Test
    void copy() {
        GDate date2 = this.date1.copy();
        assertTrue(this.date1.equals(date2));
    }

    @org.junit.jupiter.api.Test
    void toJulianDay() {
        assertEquals(2451545, this.date1.julianDay());
    }

    @org.junit.jupiter.api.Test
    void year() {
        assertEquals(2000, this.date1.year());
    }

    @org.junit.jupiter.api.Test
    void month() {
        assertEquals(1, this.date1.month());
    }

    @org.junit.jupiter.api.Test
    void day() {
        assertEquals(1, this.date1.day());
    }

    @org.junit.jupiter.api.Test
    void toFmtString() {
        assertEquals("2000.01.01", this.date1.toString());
    }
}