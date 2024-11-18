public class AutoCustomer {
    private String customerType;
    private String customerName;
    private double dInvoiceTotal;
    private double dNewInvTotal;

    public AutoCustomer(String customerType, String customerName, double dInvoiceTotal) {
        this.customerType = customerType;
        this.customerName = customerName;
        this.dInvoiceTotal = dInvoiceTotal;
        calculateDiscount();
    }

    private void calculateDiscount() {
        if ("employee".equalsIgnoreCase(customerType)) {
            this.dNewInvTotal = this.dInvoiceTotal * 0.92;
        } else if ("manager".equalsIgnoreCase(customerType)) {
            this.dNewInvTotal = this.dInvoiceTotal * 0.88;
        } else {
            this.dNewInvTotal = this.dInvoiceTotal;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Customer Type: %s\nCustomer Name: %s\nInvoice Total: $%.2f\nNew Invoice Total (After Discount): $%.2f\n",
                customerType, customerName, dInvoiceTotal, dNewInvTotal
        );
    }
}
