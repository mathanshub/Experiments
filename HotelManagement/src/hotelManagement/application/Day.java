package hotelManagement.application;



	public enum  Day {
	    MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY,SUNDAY ;
	    
	    public String eval(Day day){
	    	String result="";
	        switch(day) {
	            case MONDAY:TUESDAY:WEDNESDAY:THURSDAY:FRIDAY:   result="WEEKDAY";
	            break;
	            case SATURDAY:SUNDAY: 
	            	result="WEEKEND";	            
	        }
	        return result;
	    }
	    
	    
	}
