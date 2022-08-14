package domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ApartmentTest {
    Apartment apt = null;

    @BeforeEach
    void setUp() {
        this.apt = new Apartment();
    }

    @Test
    void setApartmentIdBelowRange() {
        assertNotEquals(this.apt.setApartmentId(99), "");
    }

    @Test
    void setApartmentIdMinimum() {
        assertEquals(this.apt.setApartmentId(100), "");
    }

    @Test
    void setApartmentIdMaximum() {
        assertEquals(this.apt.setApartmentId(199), "");
    }

    @Test
    void setApartmentAboveRange() {
        assertNotEquals(this.apt.setApartmentId(200), "");
    }

    @Test
    void setApartmentNumNull() {
        assertNotEquals(this.apt.setApartmentNum(null), "");
    }

    @Test
    void setApartmentNumEmptyString() {
        assertNotEquals(this.apt.setApartmentNum(""), "");
    }

    @Test
    void setApartmentNumMinLength() {
        assertEquals(this.apt.setApartmentNum("1"), "");
    }

    @Test
    void setApartmentNumMaxLength() {
        assertEquals(this.apt.setApartmentNum("1111"), "");
    }

    @Test
    void setApartmentNumTooLong() {
        assertNotEquals(this.apt.setApartmentNum("11111"), "");
    }

    @Test
    void setSquareFeetTooSmall() {
        assertNotEquals(this.apt.setSquareFeet(199), "");
    }

    @Test
    void setSquareFeetMinimum() {
        assertEquals(this.apt.setSquareFeet(200), "");
    }

    @Test
    void setSquareFeetMaximum() {
        assertEquals(this.apt.setSquareFeet(2000), "");
    }

    @Test
    void setSquareFeetTooLarge() {
        assertNotEquals(this.apt.setSquareFeet(2001), "");
    }

    @Test
    void setBathroomsToLow() {
        assertNotEquals(this.apt.setBathrooms(0), "");
    }

    @Test
    void setBathroomsMinimum() {
        assertEquals(this.apt.setBathrooms(1), "");
    }

    @Test
    void setBathroomsMaximum() {
        assertEquals(this.apt.setBathrooms(3), "");
    }

    @Test
    void setBathroomsTooHigh() {
        assertNotEquals(this.apt.setBathrooms(4), "");
    }

    @Test
    void setPriceTooLow() {
        assertNotEquals(this.apt.setPrice(99.99), "");
    }

    @Test
    void setPriceTooHigh() {
        assertNotEquals(this.apt.setPrice(10000.00), "");
    }

    @Test
    void getAdministrator() {
        Person person = new Person(101, "FirstName", "LastName", "UserName");
        this.apt.setAdministrator(person);
        assertEquals(this.apt.getAdministrator().getPersonId(), 101);
    }

    @Test
    void getTenant() {
        Person person = new Person(101, "FirstName", "LastName", "UserName");
        this.apt.setTenant(person);
        assertEquals(this.apt.getTenant().getPersonId(), 101);
    }

    @Test
    void getInvoice() {
        Invoice invoice1 = new Invoice(1,
                LocalDateTime.of(2019, Month.OCTOBER, 15, 0, 0),
                LocalDateTime.of(2019, Month.NOVEMBER, 1, 0, 0),
                this.apt);
        invoice1.addLineItem( new LineItem(5.0, "description5") );
        invoice1.addLineItem( new LineItem(6.0, "description6") );
        invoice1.addLineItem( new LineItem(7.0, "description7") );
        invoice1.addLineItem( new LineItem(8.0, "description8") );
        this.apt.addInvoice(invoice1);

        Invoice invoice2 = this.apt.getInvoice(0);

        assertEquals(invoice1, invoice2);               // invoice1 and invoice2 must be equal
        assertFalse(invoice1 == invoice2);    // invoice2 must be copy of invoice1

        // Test bad index = 1
        Invoice invoice3 = this.apt.getInvoice(1);
        assertTrue(invoice3 == null);
    }

    @Test
    void getInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        invoices.add( new Invoice(1,
                LocalDateTime.of(2019, Month.SEPTEMBER, 1, 0, 0),
                LocalDateTime.of(2019, Month.SEPTEMBER, 11, 0, 0),
                this.apt));
        invoices.add( new Invoice(2,
                LocalDateTime.of(2019, Month.OCTOBER, 1, 0, 0),
                LocalDateTime.of(2019, Month.OCTOBER, 11, 0, 0),
                this.apt));
        for (Invoice invoice : invoices) {
            this.apt.addInvoice(invoice);
        }

        ArrayList<Invoice> invoices2 = this.apt.getInvoices();

        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice1 = invoices.get(i);
            Invoice invoice2 = invoices2.get(i);
            assertEquals(invoice1, invoice2);               // invoice1 must equal invoice2
            assertFalse(invoice1 == invoice2);    // invoice1 must be copy of invoice2
        }
    }

    @Test
    void removeInvoice() {
        Invoice invoice1 = new Invoice(1,
                LocalDateTime.of(2019, Month.SEPTEMBER, 1, 0, 0),
                LocalDateTime.of(2019, Month.SEPTEMBER, 11, 0, 0),
                this.apt);
        this.apt.addInvoice(0, invoice1);

        Invoice invoice2 = this.apt.removeInvoice(0);
        assertEquals(invoice1, invoice2);               // invoice1 and invoice2 must be equal
        assertFalse(invoice1 == invoice2);    // invoice2 must be copy of invoice1

        // Test bad index = 0
        Invoice invoice3 = this.apt.removeInvoice(0);
        assertTrue(invoice3 == null);
    }
}