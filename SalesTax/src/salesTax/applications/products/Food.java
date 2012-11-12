package salesTax.applications.products;

import salesTax.applications.constants.Constants;

public class Food extends Product{
	
	 private double salesTaxPercent = Constants.SALES_TAX_FOR_FOOD;
	
	public Food(String name, double cost, boolean isImported) {
		// TODO Auto-generated constructor stub
		
		super(name, cost, isImported);
                super.setSalesTaxPercent(this.salesTaxPercent);
	}

}
