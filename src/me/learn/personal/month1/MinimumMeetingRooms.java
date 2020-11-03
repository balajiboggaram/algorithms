package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Title 253 :Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of
 * conference rooms required.
 * 
 * This question is same as minimum number of platform tracks to fit based on
 * incoming trains in railway station
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class MinimumMeetingRooms {

	public static void main(String args[]) {
		MinimumMeetingRooms solution = new MinimumMeetingRooms();
		//System.out.println(solution.minMeetingRooms(new int[][] { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } }));
		System.out.println(solution.minMeetingRooms(new int[][] { { 9, 10 }, { 4, 9 }, { 4, 17 } }));

	}

	public int minMeetingRooms(int[][] intervals) {

		List<Integer> startList = new ArrayList<Integer>();
		List<Integer> endList = new ArrayList<Integer>();

		for (int[] interval : intervals) {
			startList.add(interval[0]); // indicates start time or (arrival time into meeting room)
			endList.add(interval[1]); // indicates end time (departure time from meeting room)
		}
		Collections.sort(startList);
		Collections.sort(endList);

		int count = 0;
		int i = 0, j = 0, n = intervals.length;
		int maxCount = 0;
		while(i < n && j < n) {
			if(startList.get(i) < endList.get(j)) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			maxCount = Math.max(maxCount, count);
		}
		
		
		return maxCount;

	}

	/**
	 * Alternative Solution based on Sorting :
	 * 
	 * 1. Sort the input based on end times 2. Insert the first pair in to Priority
	 * Queue (sorted based on end time) 3. for every pair in the input 3.1 Remove
	 * the non-conflicting pairs from the Queue [from the head of queue] i.start >
	 * peek().end 3.2 Insert the ith pair in to queue 3.3 Track the maximum queue
	 * size at an instant as i.e Minimum # of meeting rooms required to fit all
	 * meetings
	 * 
	 * Return the maxQueueSize as answer
	 */

}
