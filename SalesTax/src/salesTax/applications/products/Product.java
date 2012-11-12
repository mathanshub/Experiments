package salesTax.applications.products;
import salesTax.applications.constants.Constants;

public abstract class Product {

	private String name;
	private double cost;
	private double salesTaxPercent;
	private boolean isImported;
	
    public Product(String name, double cost, boolean isImported) {
            this.name = name;
            this.cost = cost;
            this.salesTaxPercent = Constants.SALES_TAX_FOR_DEFAULT;
            this.isImported = isImported;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSalesTaxPercent() {
		return salesTaxPercent;
	}

	public void setSalesTaxPercent(double salesTaxPercent) {
		this.salesTaxPercent = salesTaxPercent;
	}



	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	

}
