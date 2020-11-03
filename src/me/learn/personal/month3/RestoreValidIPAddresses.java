/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 93 :
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * A valid IP address consists of exactly four integers (each integer is between
 * 0 and 255) separated by single points.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 1, 2020
 */
public class RestoreValidIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RestoreValidIPAddresses solution = new RestoreValidIPAddresses();
		System.out.println(solution.restoreIpAddresses("25525511135"));
		System.out.println(solution.restoreIpAddresses("010010"));

	}
	
	// first - 0.i
	// second - i,j
	// third - j,k
	// fourth - k,n
	public List<String> restoreIpAddresses(String s) {
		List<String> ips = new ArrayList<String>();
		int n = s.length();

		for (int i = 1; i < 4 && i < n-2; i++) {
			
 			String first = s.substring(0, i);

			if (isvalid(first)) {
				
				for (int j = i+1; j <  i+4 &&  j < n-1; j++) {
				String second = s.substring(i, j);
				
					if (isvalid(second)) {

						for (int k = j +1; k <  j+4 &&  k < n; k++) {
							String third = s.substring(j,k);
							String fourth = s.substring(k, n);
							
							System.out.println("First: " + first + " second : " + second + " third: " + third + "  Fourth : " + fourth);
						
							if(isvalid(third) && isvalid(fourth)) {
								ips.add(String.format("%s.%s.%s.%s", first, second, third, fourth));
							}
						}
					}
				}
			}
		}
		
		return ips;
	}

	// Very important on these conditions
	public boolean isvalid(String s) {
		if (s.length() > 3 || 
				s.length() == 0 || 
				(s.charAt(0) == '0' && s.length() > 1) || 
				Integer.parseInt(s) > 255)
			return false;
		return true;
	}
	
	private boolean isvalid1(String first) {
		int x = Integer.valueOf(first);
		return x >0 && x <= 255;
	}

}
