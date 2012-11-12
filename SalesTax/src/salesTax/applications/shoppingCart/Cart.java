package salesTax.applications.shoppingCart;

import java.util.HashMap;
import java.util.Iterator;

import salesTax.applications.products.Product;


public interface Cart {

        void addProduct(Product product,int quantity);

        int getItemCount();

        void getProduct(Product product);

        void empty();

        void removeProduct(Product cancelledProduct);
        
        HashMap<Product, Integer> getCartMap();
}