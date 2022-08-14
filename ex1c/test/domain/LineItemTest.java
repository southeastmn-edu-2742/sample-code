package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    LineItem lineItem1;

    @BeforeEach
    void setUp() {
        this.lineItem1 = new LineItem(1.0, "description1");
    }

//    @Test
//    void testConstructor() {
//        assertEquals(10001, this.lineItem1.getLineItemId());
//        assertEquals(1.0, this.lineItem1.getAmount());
//        assertEquals("description1", this.lineItem1.getDescription());
//    }

    @Test
    void copyConstructor() {
        LineItem lineItem2 = new LineItem(lineItem1);
        assertEquals(this.lineItem1.getLineItemId(), lineItem2.getLineItemId());
        assertEquals(this.lineItem1.getAmount(), lineItem2.getAmount());
        assertEquals(this.lineItem1.getDescription(), lineItem2.getDescription());
        assertFalse(lineItem1 == lineItem2);
    }

    @Test
    void copy() {
        LineItem lineItem2 = lineItem1.copy();
        assertEquals(this.lineItem1.getLineItemId(), lineItem2.getLineItemId());
        assertEquals(this.lineItem1.getAmount(), lineItem2.getAmount());
        assertEquals(this.lineItem1.getDescription(), lineItem2.getDescription());
        assertFalse(lineItem1 == lineItem2);
    }

    @Test
    void equals() {
        LineItem lineItem2 = this.lineItem1.copy();
        assertTrue(lineItem1.equals(lineItem2));
    }
}