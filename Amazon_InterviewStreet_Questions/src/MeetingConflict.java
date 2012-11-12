import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Scanner;

/*
Given M busy-time slots of N people, You need to print all the available time slots when all the N people can schedule a meeting for a duration of K minutes.
Event time will be of form HH MM ( where 0 <= HH <= 23 and 0 <= MM <= 59 ), K will be in the form minutes.
 
Input Format:
 
M K [ M number of busy time slots , K is the duration in minutes ]
Followed by M lines with 4 numbers on each line.
Each line will be of form StartHH StartMM EndHH EndMM  [ Example 9Am-11Am time slot will be given as 9 00 11 00 ]
An event time slot is of form [Start Time, End Time ) . Which means it inclusive at start time but doesn’t include the end time. 
So an event of form 10 00  11 00 => implies that the meeting start at 10:00 and ends at 11:00, so another meeting can start at 11:00.
 
Sample Input:
5 120
16 00 17 00
10 30 14 30
20 45 22 15
10 00 13 15
09 00 11 00
 
Sample Output:
00 00 09 00
17 00 20 45
 
Sample Input:
8 60
08 00 10 15
22 00 23 15
17 00 19 00
07 00 09 45
09 00 13 00
16 00 17 45
12 00 13 30
11 30 12 30
 
Sample Output:
00 00 07 00
13 30 16 00
19 00 22 00
 
Constraints :
1 <= M <= 100
 
Note: 24 00 has to be presented as 00 00.*/



public class MeetingConflict {
	
	
	public static int totalMin=1440;
	public static void main(String[] args) {
		
		BitSet timeSlot =new BitSet();
		timeSlot.set(0,totalMin);
		
		Scanner sc=new Scanner(System.in);
		int no_busySlots=sc.nextInt();
		int meetingDuration=sc.nextInt();
		
		for(int i=0;i<no_busySlots;i++){
			
			int begTime=sc.nextInt()*60+ sc.nextInt();
			int endTime=sc.nextInt()*60+ sc.nextInt();
			if(endTime==0)
				endTime=1439;
			if(endTime<=totalMin)
			timeSlot.set(begTime<=endTime?begTime:endTime, begTime>=endTime?begTime:endTime, false);
		}
		
		int begAvail=0; int endAvail=0;int slotTime=0;
		for(int i=0;i<totalMin;i++){
			
			if(timeSlot.get(i)==true){
				slotTime+=1;
				continue;
			}
			else{
				if(slotTime>=meetingDuration){
					//System.out.print("\n"+roundUp(begAvail/60)+" "+roundUp((begAvail-(begAvail/60)*60)));
					System.out.println();
					printResult(begAvail/60, (begAvail-(begAvail/60)*60));
					System.out.print(" ");
					printResult(i/60, (i-(i/60)*60));
					//System.out.print(" "+roundUp(i/60)+" "+roundUp((i-(i/60)*60)));
				}
				begAvail=i+1;
				slotTime=0;
			}
		}
		if(slotTime>=meetingDuration){
			//System.out.print("\n"+(begAvail/60)+" "+roundUp((begAvail-(begAvail/60)*60)));
			System.out.println();
			printResult(begAvail/60, (begAvail-(begAvail/60)*60));
			System.out.print(" ");
			printResult(0, 0);
			//System.out.print(" "+roundUp(totalMin/60)+" "+roundUp((totalMin-(totalMin/60)*60)));
		}
		
		
			
	
		
	}

	  
	  private static void printResult(int val1,int val2){
		  System.out.print((val1<10?("0"+Integer.toString(val1)):val1) +" "+ (val2<10?"0"+Integer.toString(val2):val2));
	  }

}
