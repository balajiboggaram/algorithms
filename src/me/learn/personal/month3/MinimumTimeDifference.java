/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 539 :
 * 
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list.
 * 
 * Example 1:
 * 
 * Input: ["23:59","00:00"] Output: 1
 * 
 * Note:
 * 
 * The number of time points in the given list is at least 2 and won't exceed
 * 20000. The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 1, 2020
 */
public class MinimumTimeDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumTimeDifference solution = new MinimumTimeDifference();
		System.out.println(solution.findMinDifference(Arrays.asList("23:59", "00:00")));
		System.out.println(solution.findMinDifference(Arrays.asList("23:59", "00:01")));

		System.out.println(solution.findMinDifference(Arrays.asList("00:00", "01:00")));

		System.out.println(solution.findMinDifference(Arrays.asList("07:30", "14:00",  "08:00")));
		System.out.println(solution.findMinDifference(Arrays.asList("00:35", "05:31",  "22:08")));

	}

	
	// clock machine - Runner
	public int findMinDifference(List<String> timePoints) {

		// Convert the given points to minutes
		List<Integer> input = new ArrayList<Integer>();
		for(String timePoint : timePoints) {
			String[] tokens = timePoint.split(":");
			int x = (Integer.valueOf(tokens[0]) * 60) + Integer.valueOf(tokens[1]);
			if(input.contains(x)) return 0; // the same timestamp was given twice.

			input.add( x);
		}
		
		// Now, lets try to start from 00:00 to 23:59
		int prev = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		int first = -1; // required to capture the edge case of last time with first - circular
		int last = -1;
		// ^ check the last test case
		for(int hour =0;hour < 24;hour++) {
			for(int minute = 0; minute < 60; minute++) {
				
				int curTime = (hour * 60) + minute;
				if(input.contains(curTime)) {
					
					// this time stamp exists in input
					
					if(prev == Integer.MAX_VALUE) {
						prev = curTime;
						first = prev;
					} else {
						// we need to find the min time difference here
						
						// Imagine this is a circular queue of 1440 minutes points
						
						int temp = Math.min(Math.abs(curTime - prev), 1440-curTime + prev);
						
						result = Math.min(result, temp);
						prev = curTime;
						last = curTime;
					}
				}
			}
		}	
		
		
		int lastDiff = Math.min(Math.abs(last - first), 1440-last + first);
		result = Math.min(result, lastDiff);
		
		return result;
		
	}
	
}
