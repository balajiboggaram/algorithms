/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 1353 :
 * 
 * Date : Jan 30, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaxEventsCanBeAttended {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is not interval lap... 
	// Every integer is an event, You need to know - how many events can you attend. 
	// The below is n * n, You can use TreeSet to solve in n logn 
	public int maxEvents(int[][] events) {

		// greedy thinking: sort the events based on finish time, then grab the first
		// finish event to do in 1 day
		// if there are multiple days can be used, use the earliest.
		// forgive my english

		Arrays.sort(events, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

		Set<Integer> hset = new HashSet<>();

		for (int[] e : events) {
			if (e[1] == e[0]) {
				hset.add(e[0]);
			} else {
				// if there are many days can be used grab the earliest day
				for (int i = e[0]; i <= e[1]; i++) {
					if (!hset.contains(i)) {
						hset.add(i);
						break;
					}
				}
			}
		}
		return hset.size();
	}

}
