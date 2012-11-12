package thoughtwworks.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import thoughtwworks.application.DTOs.Input;
import thoughtwworks.application.DTOs.Inventory;
import thoughtwworks.application.DTOs.Output;
import thoughtwworks.application.exceptions.InvalidInputException;
import thoughtwworks.application.inventory.InventoyFactory;

public class Application {

	public static void main(String[] args) {

		
		
		//initialize inventory list under processRequest class
		HashMap<String,Inventory> inventoryList = InventoyFactory.initializeInventory();
		
		System.out.println(inventoryList.get("Argentina").getCountryName());
		try {
			Input input = InputParser.inputParser();			
			ProcessRequest pRquest=new ProcessRequest(input, inventoryList);
			//Output output=new Output(inventoryList);
			Output output=pRquest.process();
			OutputParser.parseAndPrintOuput(output);
			
		} catch (InvalidInputException invalidInputException) {
			 System.out.println("Please check your input file for correct format");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
