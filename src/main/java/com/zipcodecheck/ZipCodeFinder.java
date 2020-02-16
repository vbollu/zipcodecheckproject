package com.zipcodecheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ZipCodeFinder {
	
	
	/**
	 * Method to calculate minimum number of ranges required from give zip code ranges
	 */
	public List<ZipCode> findZipCodeRestrictions(String... args) {
		
		if(args.length == 0) {
			System.out.println("Please provide input");
			return null;
		}
		
		List<ZipCode> zipcodesList = new ArrayList<ZipCode>(); 
		
		//Extract given zip codes and make Zipcode object list with start and end codes
		List<String> zipcodesStringList =Arrays.asList(args[0].split(" "));
		for(String zipcodesString: zipcodesStringList) {
			String[] codes = zipcodesString.replace("[", "").replace("]", "").split(",");
			
			//Check for invalid ranges
			if(codes.length != 2) {
				System.out.println("One or more invalid ranges provided.");
				return null;
			}
			//Check for invalid lengths
			if(codes[0].length() != 5 || codes[1].length() !=5) {
				System.out.println("One of more invalid zip codes.");
				return null;
			}
			ZipCode zipcode  = new ZipCode();
			zipcode.setStartZipCode(Integer.valueOf(codes[0]));
			zipcode.setEndZipCode(Integer.valueOf(codes[1]));
			zipcodesList.add(zipcode);
		}
		
		//Sort list based on sart zip code
		zipcodesList.sort((ZipCode o1, ZipCode o2)->o1.getStartZipCode()-o2.getStartZipCode());
		
		//Take each item and compare with rest of the items, if any overlap between two then combine items into one item
		for(int i=0;i<zipcodesList.size();i++) {
			for (int j=i+1;j<zipcodesList.size();j++) {
					//if second item start zip code is greater than first item end zip code then dont compare first item with anyother items
					if(zipcodesList.get(i).getEndZipCode() < zipcodesList.get(j).getStartZipCode()) {
						break;
					}
					
					//Compare only if item end code greater than next item start zip code
					if(zipcodesList.get(i).getEndZipCode() >=zipcodesList.get(j).getStartZipCode()) {
						
						//if item end zip code less than or equal to next item end zip code, then set item end zip code to next item end zip code and remove next item.
						if(zipcodesList.get(i).getEndZipCode() <=zipcodesList.get(j).getEndZipCode()) {
							zipcodesList.get(i).setEndZipCode(zipcodesList.get(j).getEndZipCode());
							zipcodesList.remove(j);
							j--;
							continue;
						}
						
						//if item end zip code greater than next item zip code then just keep item and remove next item
						if(zipcodesList.get(i).getEndZipCode() >zipcodesList.get(j).getEndZipCode()) {
							zipcodesList.remove(j);
							j--;
							continue;
						}
				}
			}
			
		}
		
		//Printing  minimum number of ranges required 
		for(int i=0;i<zipcodesList.size();i++) {
			System.out.println(zipcodesList.get(i).getStartZipCode()+" "+zipcodesList.get(i).getEndZipCode());
			
		}
		
		return zipcodesList;
		
	}
	
	

}
