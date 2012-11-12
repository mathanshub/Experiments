package salesTax.applications;



import java.io.IOException;

import salesTax.exceptions.InvalidInputException;
public class Application {

	
	public static void main(String[] args) {
		
		// Process the user request and print the bill for it.
		 ProcessRequest pRequest = new ProcessRequest();
         Receipt receipt = null;
                 try {
                         receipt = pRequest.performTransaction();
                         //print the receipt 
                         Printer printer=new Printer(receipt);
                         printer.print();
                 } catch (InvalidInputException invalidInputException) {
                         System.out.println("Please check your input file for correct format");
                 }  catch (NumberFormatException e) {
                         e.printStackTrace();
                 } catch (IOException e) {
                         e.printStackTrace();
                 }
		
	}
	
}
