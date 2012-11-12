package salesTax.applications.products;

import salesTax.applications.constants.Constants;

public class Book extends Product {
	
	private double salesTaxPercent = Constants.SALES_TAX_FOR_BOOKS;

    public Book(String title, double cost, boolean isImported) {

    	super(title, cost,isImported);
    	super.setSalesTaxPercent(this.salesTaxPercent);
    }

}
