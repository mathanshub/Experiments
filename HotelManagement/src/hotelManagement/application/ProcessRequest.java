package hotelManagement.application;

import hotelManagement.application.exceptions.InvalidInputException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;

public class ProcessRequest {

	
	
	
	
	public void process(){
		
		BranchFactory bFactory=new BranchFactory();
		ArrayList<HotelBranches> branchList=bFactory.getBranchFactory();
		
		try{
		InputData inputData=InputParser.parseInput();
		
		OutputData outputData=getFavourable(branchList, inputData);
		
		}
		catch(InvalidInputException ex){
			
		}
		catch(IOException ex){
			
		}
	}
	
	private OutputData getFavourable(ArrayList<HotelBranches> branchList,InputData inputData){
		OutputData outputData=new OutputData();
		outputData.setCost(9999999999l);
		outputData.setRating(1);
		for(HotelBranches branch:branchList){
			float expense=0;
			ArrayList<Day> days=inputData.getDays();
			
			if(inputData.getCustomer().equalsIgnoreCase("REGULAR")){
						for(Day day:days){
								String type=day.eval(day);
								if(type.equalsIgnoreCase("WEEKDAY"))
									 expense+=branch.getRegularWeekDayCost();
								else
									expense+=branch.getRegularWeekEndCost();
							}
							
			}
			else if(inputData.getCustomer().equalsIgnoreCase("REWARDEE")){
				for(Day day:days){
						String type=day.eval(day);
						if(type.equalsIgnoreCase("WEEKDAY"))
							 expense+=branch.getRewardeeWeekDayCost();
						else
							expense+=branch.getRewardeeWeenEndCost();
					}
					
			}
			
			if(outputData.getCost()>expense || (outputData.getCost()==expense  && branch.getStar()>outputData.getRating())){
				outputData.setCompanyName(branch.name);
				outputData.setCost(expense);
				outputData.setRating(branch.star);
			}
	}
			
		
		
		
		return outputData;
	}
	
	
}
