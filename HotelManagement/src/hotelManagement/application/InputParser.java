package hotelManagement.application;

import hotelManagement.application.exceptions.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class InputParser {

	 private static InputData inputData;
	
	public InputParser() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public static  InputData parseInput() throws InvalidInputException,IOException{
		
		inputData=new InputData();
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String inputLine=bf.readLine();
		
		String[] inputTokens=inputLine.split(",");
		inputData.setCustomer(inputTokens[0]);
		
		
		ArrayList<Day> days=new ArrayList<Day>();
		for(int i=1;i<inputTokens.length;i++){
			String temp=inputTokens[i].split("(")[1];
			String inputDay=temp.substring(0, temp.length()-2);
			Day day;
			if(inputDay.equalsIgnoreCase("MONDAY")){
				days.add(Day.MONDAY);
			}
			else if(inputDay.equalsIgnoreCase("TUESDAY")){
				days.add(Day.TUESDAY);
			}
			else if(inputDay.equalsIgnoreCase("TUESDAY")){
				days.add(Day.TUESDAY);
			}
			else if(inputDay.equalsIgnoreCase("WEDNESDAY")){
				days.add(Day.TUESDAY);
			}
			else if(inputDay.equalsIgnoreCase("THURSDAY")){
				days.add(Day.TUESDAY);
			}
			else if(inputDay.equalsIgnoreCase("FRIDAY")){
				days.add(Day.TUESDAY);
			}
			else if(inputDay.equalsIgnoreCase("SATURDAY")){
				days.add(Day.TUESDAY);
			}
			else if(inputDay.equalsIgnoreCase("SUNDAY")){
				days.add(Day.TUESDAY);
			}
			else{
				throw new InvalidInputException();
			}
			
		}
		inputData.setDays(days);
		
		
		
		
		return inputData;
		
		
	}
	
	public InputData getInputArrayData(){
		
		return inputData;
		
	}
	
}
