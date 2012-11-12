package thoughtwworks.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import thoughtwworks.application.DTOs.Input;
import thoughtwworks.application.exceptions.InvalidInputException;

public class InputParser {

	
	public InputParser() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static Input inputParser()throws InvalidInputException,IOException{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String inputString=bf.readLine();
		String[] inputTokens=inputString.split(":");
		
		Input input=new Input();
		input.setCountryName(inputTokens[0]);
		input.setCount(Integer.parseInt(inputTokens[1]));
		
		
		return input;
		
		
	}
	
	
	public static Input testInput(){

		Input input=new Input();
		input.setCountryName("Brazil");
		input.setCount(150);
		return input;
		
	}
	
}
