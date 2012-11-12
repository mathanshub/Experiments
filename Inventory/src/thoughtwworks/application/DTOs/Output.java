package thoughtwworks.application.DTOs;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class Output {
	
	
	LinkedHashMap<String,Integer> result=new LinkedHashMap<String, Integer>();
	float cost;
	//HashMap<String,Inventory> result=new HashMap<String, Inventory>();
	public Output() {
		// TODO Auto-generated constructor stub
		this.setCost(0);
	}
	public Output(HashMap<String,Inventory> inventoryList) {
		// TODO Auto-generated constructor stub
		
		for(String cName:inventoryList.keySet()){
			result.put(cName,inventoryList.get(cName).getCount());
		}
		this.setResult(result);
		this.setCost(0);
	}

	
	
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public LinkedHashMap<String, Integer> getResult() {
		return result;
	}
	public void setResult(LinkedHashMap<String, Integer> result) {
		this.result = result;
	}
	
	public void ouputWriter(int processCount,Inventory inventory,Boolean shipping){
		
		if(shipping)
			this.cost+= ((processCount*100)/40)+processCount*inventory.getCost();
		else
			this.cost+= processCount*inventory.getCost();
				
		
//		inventory.setCount(inventory.count-processCount);
			
		//if(result==null){
		
		
		//Inventory inv=result.get(inventory.countryName);
		//inv.setCount(inventory.count-processCount);
			result.put(inventory.countryName,inventory.count-processCount);
		//}
		
	}
	
}
