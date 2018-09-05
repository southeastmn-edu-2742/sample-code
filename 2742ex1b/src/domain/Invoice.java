package domain;

public class Invoice {
    private int invoiceId;
    private int status;
    private GDate invoiceDate;
    private LineItem[] lineItems;

    /**
     *
     * @param status
     * @param invoiceDate
     */
    public Invoice(int status, GDate invoiceDate) {
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
    public void addLineItem(int lineItem) {
        // TODO - implement Invoice.addLineItem
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param lineItemId
     */
    public LineItem removeLineItem(int lineItemId) {
        // TODO - implement Invoice.removeLineItem
        throw new UnsupportedOperationException();
    }

    public double total() {
        // TODO - implement Invoice.total
        throw new UnsupportedOperationException();
    }
}
