/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Title 1376 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class TimeNeededToInformAllEmployees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, List<Integer>> map = new HashMap<>();

	// return the minimum time required to inform all the employees
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		
		if(n == 1) return 0;

		Queue<Integer> q = new LinkedList<>();

		// map of manager -> list of employees
		for (int i = 0; i < n; i++) {
			int eId = i;
			int managerId = manager[i];
			map.computeIfAbsent(managerId, f -> new ArrayList<Integer>()).add(eId);
		}

		q.add(headID);
		int maxTime = Integer.MIN_VALUE;
		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int temp = q.poll();

				if (manager[temp] != -1) { // if he is not head
					// update the inform time
					informTime[temp] = informTime[temp] + informTime[manager[temp]];
					maxTime = Math.max(maxTime, informTime[temp]);
				}

				if (map.get(temp) != null) {
					map.get(temp).forEach(x -> q.add(x)); // add the sub ordinates of this manager
				}
				
				map.remove(temp); // remove that manager as its already done processing
			}
		}

		return maxTime;
	}
}
