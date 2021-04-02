/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Title 1167 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinCostConnectSticks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int connectSticks(int[] sticks) {

		int n = sticks.length;
		if (n == 1)
			return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Arrays.stream(sticks).forEach(x -> pq.add(x));

		int cost = 0;
		while (pq.size() > 1) {
			int stick1 = pq.poll();
			int stick2 = pq.poll();
			cost += (stick1 + stick2);
			pq.offer(stick1 + stick2);
		}
		
		return cost;

	}
}
