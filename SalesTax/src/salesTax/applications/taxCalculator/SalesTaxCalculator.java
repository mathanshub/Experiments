package salesTax.applications.taxCalculator;

import java.math.BigDecimal;

import salesTax.applications.constants.Constants;
import salesTax.applications.products.Product;

public class SalesTaxCalculator {

	
	        double totalSalesTaxForThisProduct;
	        public double getSalesTax(Product product,int quantity) {
	        
	        if(product.isImported()){
	        	
	        	totalSalesTaxForThisProduct=(product.getSalesTaxPercent()+Constants.IMPORT_DUTY_FOR_IMPORTED)*product.getCost()*quantity/100;
	        	
	        }
	        
	        else{
	        	
	        	totalSalesTaxForThisProduct = (product.getSalesTaxPercent() * product.getCost() * quantity) / 100;
	        }

	        return roundUpSalesTax(totalSalesTaxForThisProduct, Constants.NEAREST_N_PAISE);
	}

	    
	    private double roundUpSalesTax(double totalSalesTaxForThisProduct, int nearestFiveCents) {
	        BigDecimal bigDecimalRepresentation = new BigDecimal(
	                        Double.toString(totalSalesTaxForThisProduct));
	        double scaledNumber = bigDecimalRepresentation.setScale(Constants.REQUIRED_DECIMAL_PLACES,
	                        BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
	        double resolution = scaledNumber % Constants.NEAREST_N_PAISE;
	        if (resolution != 0) {
	                scaledNumber += Constants.NEAREST_N_PAISE - resolution;
	        }
	        return scaledNumber / 100;
	    }
	    
}
