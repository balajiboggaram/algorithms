package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Title 1094 : You are driving a vehicle that has capacity empty seats
 * initially available for passengers. The vehicle only drives east (ie. it
 * cannot turn around and drive west.)
 * 
 * Given a list of trips, trip[i] = [num_passengers, start_location,
 * end_location] contains information about the i-th trip: the number of
 * passengers that must be picked up, and the locations to pick them up and drop
 * them off. The locations are given as the number of kilometers due east from
 * your vehicle's initial location.
 * 
 * 
 * This logic is similar to Platforms and Railway stations. deduce to it.
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class CarPooling {

	public static void main(String args[]) {
		CarPooling solution = new CarPooling();
		System.out.println(solution.carPooling(new int[][] {{2,1,5},{3,3,7}}, 4));
		System.out.println(solution.carPooling(new int[][] {{2,1,5},{3,3,7}}, 5));
		System.out.println(solution.carPooling(new int[][] {{7,5,6},{6,7,8}, {10,1,6}}, 16));

	}

	public boolean carPooling(int[][] trips, int capacity) {

		List<Pair> startList = new ArrayList<Pair>();
		List<Pair> endList = new ArrayList<Pair>();

		for (int[] interval : trips) {
			startList.add(new Pair(interval[1], interval[0])); // indicates start time or (arrival time into meeting room)
			endList.add(new Pair(interval[2], interval[0])); // indicates end time (departure time from meeting room)
		}
		Collections.sort(startList);
		Collections.sort(endList);

		int i = 0, j = 0, n = trips.length;
		int count = 0;
		while (i < n && j < n) {
			if(startList.get(i).time < endList.get(j).time) {
				count += startList.get(i).passengers;
				i++;
			} else {
				count -= startList.get(j).passengers;
				j++;
			}
			if(count > capacity) {
				return false;
			}
		}
		return true;
	}

}

class Pair implements Comparable<Pair> {

	int time;
	int passengers;

	public Pair(int i, int j) {
		this.time = i;
		this.passengers = j;
	}

	@Override
	public int compareTo(Pair o) {
		return this.time - o.time;
	}

}
