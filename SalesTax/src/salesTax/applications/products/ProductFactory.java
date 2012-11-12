package salesTax.applications.products;

import salesTax.applications.CategoryLookup;
import salesTax.applications.InputData;
import salesTax.applications.constants.Constants;




public class ProductFactory {

		Product product;
       
        public static Product createProduct(InputData inputData) {

            Product product = null;
            CategoryLookup lookup = CategoryLookup.getInstance();
			String name = inputData.getProductDescription();
			double cost = inputData.getCost();
			boolean isImported = inputData.isImported();
			String category = lookup.getCategoryFor(name);

            if (category.equals(Constants.BOOKS)) {
                    product = new Book(name, cost, isImported);
            } else if (category.equals(Constants.FOOD_PRODUCT)) {
                    product = new Food(name, cost, isImported);
            } else if (category.equals(Constants.MEDICAL_PRODUCT)) {
                    product = new Medicine(name, cost, isImported);
            } else {
                    product = new Other(name, cost, isImported);
            }

            return product;
    }

}
