package salesTax.applications;

import java.io.IOException;
import java.util.ArrayList;
import salesTax.applications.products.Product;
import salesTax.applications.products.ProductFactory;
import salesTax.applications.shoppingCart.Cart;
import salesTax.applications.shoppingCart.CustomerCart;
import salesTax.exceptions.InvalidInputException;

public class ProcessRequest {
	ArrayList<InputData> inputData;
	Cart customerCart;
	Receipt receipt;


	public ProcessRequest() {
		customerCart = new CustomerCart();
	}

	public Receipt performTransaction()
			throws InvalidInputException, NumberFormatException, IOException {
		//collect the input data
		inputData = new InputParser().getInputData();

		//Add all the input item to the shopping cart of that user
		for (InputData data : inputData) {
			int quantity = data.getQuantity();
			Product product=ProductFactory.createProduct(data);
			customerCart.addProduct(product,quantity);
		}
		//get the receipt for the given cart items
		receipt = new Receipt(customerCart);
		return receipt;
	}

}
