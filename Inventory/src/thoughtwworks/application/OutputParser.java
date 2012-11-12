package thoughtwworks.application;

import thoughtwworks.application.DTOs.Output;

public class OutputParser {
	
	public OutputParser() {
		// TODO Auto-generated constructor stub
	}
	
	public static void parseAndPrintOuput(Output output){
		
		System.out.print("\n"+output.getCost());
		
		for(String cName:output.getResult().keySet()){
			
			System.out.print("\t"+output.getResult().get(cName));
			
			
		}
		
		
		
	}

}
