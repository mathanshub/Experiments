package salesTax.applications;

public class Printer {

    Receipt receipt;

    public Printer(Receipt eReceipt) {
            this.receipt = eReceipt;
    }

    public void print() {
            this.receipt.print();
    }
}