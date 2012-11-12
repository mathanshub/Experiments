package salesTax.applications.products;

import salesTax.applications.constants.Constants;

public class Medicine extends Product {

    private double salesTaxPercent = Constants.SALES_TAX_FOR_MEDICAL;

    public Medicine(String name, double cost, boolean isImported) {
            super(name, cost,isImported);
            super.setSalesTaxPercent(this.salesTaxPercent);
    }

}