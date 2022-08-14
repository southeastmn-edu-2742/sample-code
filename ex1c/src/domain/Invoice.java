package domain;

import java.util.ArrayList;

public class Invoice {

    private int invoiceId;
    private int status;
    private GDate invoiceDate;
    private LineItem[] lineItems;
    private GDate dueDate;

    /**
     *
     * @param status
     * @param invoiceDate
     * @param dueDate
     */
    public Invoice(int status, GDate invoiceDate, GDate dueDate) {
        // TODO - implement Invoice.Invoice
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param invoice
     */
    public Invoice(Invoice invoice) {
        // TODO - implement Invoice.Invoice
        throw new UnsupportedOperationException();
    }

    public Invoice copy() {
        // TODO - implement Invoice.copy
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param lineItem
     */
    public void addLineItem(LineItem lineItem) {
        // TODO - implement Invoice.addLineItem
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param index
     */
    public LineItem removeLineItem(int index) {
        // TODO - implement Invoice.removeLineItem
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param lineItem
     */
    public LineItem removeLineItem(LineItem lineItem) {
        // TODO - implement Invoice.removeLineItem
        throw new UnsupportedOperationException();
    }

    public double total() {
        // TODO - implement Invoice.total
        throw new UnsupportedOperationException();
    }

    public int getInvoiceId() {
        // TODO - implement Invoice.getInvoiceId
        throw new UnsupportedOperationException();
    }

    public int getStatus() {
        // TODO - implement Invoice.getStatus
        throw new UnsupportedOperationException();
    }

    public GDate getInvoiceDate() {
        // TODO - implement Invoice.getInvoiceDate
        throw new UnsupportedOperationException();
    }

    public GDate getDueDate() {
        // TODO - implement Invoice.getDueDate
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        // TODO - implement Invoice.toString
        throw new UnsupportedOperationException();
    }

    public LineItem getLineItem(int index) {
        // TODO - implement Invoice.getLineItem
        throw new UnsupportedOperationException();
    }

    public ArrayList<LineItem> getLineItems() {
        // TODO - implement Invoice.getLineItems
        throw new UnsupportedOperationException();
    }

}
