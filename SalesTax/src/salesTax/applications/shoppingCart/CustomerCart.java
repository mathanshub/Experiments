package salesTax.applications.shoppingCart;

import java.util.HashMap;

import salesTax.applications.products.Product;


public class CustomerCart implements Cart {

        private HashMap<Product, Integer> CustomerCartMap=new HashMap<Product, Integer>();

        public CustomerCart(){
        	CustomerCartMap = new HashMap<Product, Integer>();
        }

        @Override
        public void addProduct(Product product,int quantity) {
        	CustomerCartMap.put(product,quantity);
        }

        @Override
        public int getItemCount() {
                return CustomerCartMap.size();
        }

       /* @Override
        public Iterator iterator() {
                return cartMa;
        }
*/
        @Override
        public void getProduct(Product product) {
        	CustomerCartMap.remove(product);
        }

        @Override
        public void empty() {
        	CustomerCartMap.clear();
        }

        @Override
        public void removeProduct(Product cancelledProduct) {
        	CustomerCartMap.remove(cancelledProduct);
        }

		public HashMap<Product, Integer> getCartMap() {
			return CustomerCartMap;
		}

}