package domain;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class DbContext {
    private static int previousInvoiceId = 1000;
    private static int previousLineItemId = 10000;

    public static int getNextInvoiceId() {
        return ++previousInvoiceId;
    }

    public static int getNextLineItemId() {
        return ++previousLineItemId;
    }

    public static ArrayList<Invoice> getInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();

        LocalDateTime date1 = LocalDateTime.of(2019, Month.SEPTEMBER, 1, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2019, Month.SEPTEMBER, 11, 0, 0);

        Invoice invoice1 = new Invoice(1, date1, date2, null);
        invoice1.addLineItem( new LineItem(1.0, "description1") );
        invoice1.addLineItem( new LineItem(2.0, "description2") );
        invoice1.addLineItem( new LineItem(3.0, "description3") );
        invoice1.addLineItem( new LineItem(4.0, "description4") );
        invoices.add(invoice1.copy());

        Invoice invoice2 = new Invoice(2,
                LocalDateTime.of(2019, Month.OCTOBER, 15, 0, 0),
                LocalDateTime.of(2019, Month.NOVEMBER, 1, 0, 0),
                null);
        invoice2.addLineItem( new LineItem(5.0, "description5") );
        invoice2.addLineItem( new LineItem(6.0, "description6") );
        invoice2.addLineItem( new LineItem(7.0, "description7") );
        invoice2.addLineItem( new LineItem(8.0, "description8") );
        invoices.add(invoice2.copy());

        return invoices;
    }

    public static ArrayList<Apartment> getApartments() {
        ArrayList<Apartment> apartments = new ArrayList<Apartment>();
        Apartment apartment = new Apartment();
        apartment.setApartmentId(101);
        apartment.setApartmentNum("101");
        apartment.setSquareFeet(1001);
        apartment.setBathrooms(1);
        apartment.setPrice(1000.01);
        ArrayList<Invoice> invoices = getInvoices();
        for (Invoice invoice : invoices) {
            apartment.addInvoice(invoice);
        }
        apartments.add(apartment);

        apartment = new Apartment();
        apartment.setApartmentId(102);
        apartment.setApartmentNum("102");
        apartment.setSquareFeet(1002);
        apartment.setBathrooms(2);
        apartment.setPrice(1000.02);
        invoices = getInvoices();
        for (Invoice invoice : invoices) {
            apartment.addInvoice(invoice);
        }
        apartments.add(apartment);

        return apartments;
    }
}
