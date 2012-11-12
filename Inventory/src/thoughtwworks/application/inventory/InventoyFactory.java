package thoughtwworks.application.inventory;

import java.util.HashMap;

import thoughtwworks.application.DTOs.Inventory;

public class InventoyFactory {
	
	
	//private static ArrayList<Inventory> inventoryList;
	
	private static HashMap<String, Inventory> inventoryList;
	public InventoyFactory() {
		// TODO Auto-generated constructor stub
		//inventoryList=new HashMap<String, Inventory>();
	}
	
	public static HashMap<String, Inventory> initializeInventory(){
		inventoryList=new HashMap<String, Inventory>();
		Inventory inv=new Inventory();
		inv.setCountryName("Argentina");
		inv.setCost(100);
		inv.setCount(100);
		inventoryList.put("Argentina", inv);
		
		
		Inventory inv2=new Inventory();
		inv2.setCountryName("Brazil");
		inv2.setCost(50);
		inv2.setCount(100);
		inventoryList.put("Brazil", inv2);
		
		
		return inventoryList;
	}

}
