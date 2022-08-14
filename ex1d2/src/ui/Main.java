package ui;

import domain.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Invoice>  invoices = DbContext.getInvoices();
//        for (Invoice invoice : invoices) {
//            System.out.println(invoice.toShortString());
//        }
        ArrayList<Apartment> apartments = DbContext.getApartments();
        for (Apartment apartment : apartments) {
            System.out.println(apartment.toString());
            ArrayList<Invoice> invoices = apartment.getInvoices();
            System.out.println("\tInvoices:");
            for (Invoice invoice : invoices) {
                System.out.println("\t\t" + invoice.toShortString());
            }
            System.out.println();
        }
    }
}
