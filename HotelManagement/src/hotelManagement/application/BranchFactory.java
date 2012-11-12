package hotelManagement.application;

import hotelManagement.application.constants.Constants;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;

public class BranchFactory {
	
	
	
	ArrayList<HotelBranches> hotelBranchesList;
	
	
	BranchFactory(){
		hotelBranchesList=new ArrayList<HotelBranches>();
		hotelBranchesList=initializeBranchFactory();
		setBranchFactory(hotelBranchesList);
	}
	
	private ArrayList<HotelBranches> initializeBranchFactory(){
		
		ArrayList<HotelBranches> branchList=new ArrayList<HotelBranches>();
		HotelBranches branch1=new HotelBranches();
		branch1.setName("BRIDGEWOOD");
		branch1.setRegularWeekDayCost(Constants.BRANCH_BRIDGEWOOD_REGULAR_WEEKDAY);
		branch1.setRegularWeekEndCost(Constants.BRANCH_BRIDGEWOOD_REGULAR_WEEKENDS);
		branch1.setRewardeeWeekDayCost(Constants.BRANCH_BRIDGEWOOD_REWARDEE_WEEKDAYS);
		branch1.setRewardeeWeenEndCost(Constants.BRANCH_BRIDGEWOOD_REWARDEE_WEEKENDS);
		branchList.add(branch1);
		
		HotelBranches branch2=new HotelBranches();
		branch2.setName("LAKEWOOD");
		branch2.setRegularWeekDayCost(Constants.BRANCH_LAKEWOOD_REGULAR_WEEKDAY);
		branch2.setRegularWeekEndCost(Constants.BRANCH_LAKEWOOD_REGULAR_WEEKENDS);
		branch2.setRewardeeWeekDayCost(Constants.BRANCH_LAKEWOOD_REWARDEE_WEEKDAYS);
		branch2.setRewardeeWeenEndCost(Constants.BRANCH_LAKEWOOD_REWARDEE_WEEKENDS);
		branchList.add(branch2);
		
		HotelBranches branch3=new HotelBranches();
		branch3.setName("RIDGEWOOD");
		branch3.setRegularWeekDayCost(Constants.BRANCH_RIDGEWOOD_REGULAR_WEEKDAY);
		branch3.setRegularWeekEndCost(Constants.BRANCH_RIDGEWOOD_REGULAR_WEEKENDS);
		branch3.setRewardeeWeekDayCost(Constants.BRANCH_RIDGEWOOD_REWARDEE_WEEKDAYS);
		branch3.setRewardeeWeenEndCost(Constants.BRANCH_RIDGEWOOD_REWARDEE_WEEKENDS);
		branchList.add(branch3);
		
		
		return branchList;
	}
	
	private void setBranchFactory(ArrayList<HotelBranches> branchList){
		hotelBranchesList=branchList;
		
	}
	public ArrayList<HotelBranches> getBranchFactory(){
		return hotelBranchesList;
		
	}

}
