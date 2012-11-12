package salesTax.applications;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import salesTax.applications.constants.Constants;
import salesTax.applications.products.Product;
import salesTax.applications.shoppingCart.Cart;
import salesTax.applications.taxCalculator.SalesTaxCalculator;

public class Receipt {

        private static class ReceiptItems {
                private int quantity;
                private String name;
                private BigDecimal totalCost;
                private BigDecimal salesTax;
                private boolean isImported;

                public ReceiptItems(int quantity, String name, double salesTax, double totalCost,
                                boolean isImported) {
                        this.quantity = quantity;
                        this.name = name;
                        this.salesTax = new BigDecimal(Double.toString(salesTax)).setScale(2,
                                        BigDecimal.ROUND_HALF_EVEN);
                        this.totalCost = new BigDecimal(Double.toString(totalCost)).setScale(2,
                                        BigDecimal.ROUND_HALF_EVEN);
                        this.isImported = isImported;
                }

        }

        private ArrayList<ReceiptItems> receiptItemsList;
        private double grandSalesTaxesTotal = 0;
        private double grandBaseCostTotal = 0;
        private double grandOverallTotal = 0;

        private Cart cart;

        public Receipt(Cart cart) {
                this.cart = cart;
                this.receiptItemsList =  new ArrayList<ReceiptItems>();
                generateReceipt();
        }

        public BigDecimal getTotal() {
                BigDecimal total = new BigDecimal(Double.toString(grandOverallTotal)).setScale(
                                Constants.REQUIRED_DECIMAL_PLACES, BigDecimal.ROUND_HALF_EVEN);
                return total;
        }

        public BigDecimal getSalesTax() {

                BigDecimal salesTaxes = new BigDecimal(Double.toString(grandSalesTaxesTotal)).setScale(
                                Constants.REQUIRED_DECIMAL_PLACES, BigDecimal.ROUND_HALF_EVEN);
                return salesTaxes;

        }

        private void generateReceipt() {
                
        	HashMap<Product, Integer> cartMap=cart.getCartMap();
        	SalesTaxCalculator salesTaxCal=new SalesTaxCalculator();
                
                for(Product product:cartMap.keySet()){
                    int quantity = cartMap.get(product);
                    
                    String name = product.getName();
                    boolean isImported = product.isImported();
                    double totalBaseCost = product.getCost();
                    double totalSalesTax = salesTaxCal.getSalesTax(product,quantity);
                    double totalCostForThisProduct = totalBaseCost
                                    + totalSalesTax;

                    grandSalesTaxesTotal += totalSalesTax;
                    grandBaseCostTotal += totalBaseCost;

                    receiptItemsList.add(new ReceiptItems(quantity, name, totalSalesTax,
                                    totalCostForThisProduct, isImported));
                	
                    grandOverallTotal = grandBaseCostTotal + grandSalesTaxesTotal;
                }
                
                

               
        }

        public void print() {
                for (ReceiptItems item : receiptItemsList) {
                        System.out.print(item.quantity);
                        if (item.isImported)
                                System.out.print(" Imported ");
                        System.out.println(item.name + " : " + item.totalCost);

                }

                System.out.println("\nSales Taxes:\t"
                                + new BigDecimal(Double.toString(grandSalesTaxesTotal)).setScale(2,
                                                BigDecimal.ROUND_HALF_EVEN));
                System.out.println("Total:\t"
                                + new BigDecimal(Double.toString(grandOverallTotal)).setScale(2,
                                                BigDecimal.ROUND_HALF_EVEN));
                cart.empty();
        }
}
