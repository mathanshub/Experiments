package thoughtwworks.application;

import java.util.HashMap;

import thoughtwworks.application.DTOs.Input;
import thoughtwworks.application.DTOs.Inventory;
import thoughtwworks.application.DTOs.Output;


public class ProcessRequest {

	Input input;
	HashMap<String,Inventory> inventoryList;
	public ProcessRequest(){
		
	}
	
	public ProcessRequest(Input input,HashMap<String,Inventory> inventoryList) {
		// TODO Auto-generated constructor stub
		this.input=input;
		this.inventoryList=inventoryList;
		
	}
	
	
	public Output process(){
		
		Output output=new Output(inventoryList);
		ProcessRequest pRequest=new ProcessRequest();
		if(!pRequest.validateRequest())
				System.out.println("Cannot process request");
		else{
			int serveRequest=input.getCount();
			if(inventoryList.containsKey(input.getCountryName())){
				Inventory inventory=inventoryList.get(input.getCountryName());
				int toProcess=input.getCount()<inventory.getCount()?input.getCount():inventory.getCount();
				serveRequest-=toProcess;
				output.ouputWriter(toProcess,inventory,false);
				inventoryList.remove(input.getCountryName());
				
			}
			
			while(serveRequest!=0){
					for(String cName:inventoryList.keySet()){
					
						Inventory inventory=inventoryList.get(cName);
						int toProcess=serveRequest<inventory.getCount()?serveRequest:inventory.getCount();
						serveRequest-=toProcess;
						output.ouputWriter(toProcess,inventory,true);
						inventoryList.remove(input.getCountryName());
						}
						
			}
		}
			
				
			
		
		
		
		return output;
		
	}
	
	public boolean validateRequest(){
		
		boolean valid=true;
		int avaiCount=0;
		for(String cName:inventoryList.keySet()){
			
			Inventory inventory=inventoryList.get(cName);
			avaiCount+=inventory.getCount();
			
		}
		
		if(avaiCount<input.getCount())
			valid=false;

		return valid;	
		
	}
	
	
}
