package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    Invoice invoice1;

    @BeforeEach
    void setUp() {
        this.invoice1 = new Invoice(1, new GDate(), new GDate());
    }

    @Test
    void copyConstructor() {
        Invoice invoice2 = new Invoice(this.invoice1);
        assertEquals(this.invoice1.getInvoiceId(), invoice2.getInvoiceId());
        assertEquals(this.invoice1.getStatus(), invoice2.getStatus());
        assertEquals(this.invoice1.getInvoiceDate().julianDay(), invoice2.getInvoiceDate().julianDay());
        assertEquals(this.invoice1.getDueDate().julianDay(), invoice2.getDueDate().julianDay());
        assertNotEquals(this.invoice1.getInvoiceDate(), invoice2.getInvoiceDate());
        assertNotEquals(this.invoice1.getDueDate(), invoice2.getDueDate());
    }

    @Test
    void copy() {
        Invoice invoice2 = this.invoice1.copy();
        assertEquals(this.invoice1.getInvoiceId(), invoice2.getInvoiceId());
        assertEquals(this.invoice1.getStatus(), invoice2.getStatus());
        assertEquals(this.invoice1.getInvoiceDate().julianDay(), invoice2.getInvoiceDate().julianDay());
        assertEquals(this.invoice1.getDueDate().julianDay(), invoice2.getDueDate().julianDay());
        assertNotEquals(this.invoice1.getInvoiceDate(), invoice2.getInvoiceDate());
        assertNotEquals(this.invoice1.getDueDate(), invoice2.getDueDate());
    }

//    @Test
//    void addLineItem() {
//    }
//
//    @Test
//    void removeLineItem() {
//    }
//
//    @Test
//    void total() {
//    }
}