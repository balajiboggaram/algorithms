/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title 332 :
 * 
 * Date : Feb 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class ReconstructFlightItenary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		flights = new HashMap<>();
		path = new LinkedList<>();
	
		// prepare the adjacency list  flight source (dep) -> all other connections (arrivals)
		for (String[] ticket : tickets) {
			flights.putIfAbsent(ticket[0], new PriorityQueue<>());
			flights.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK"); // you start from JFK as given in the problem
		return path;
	}

	public void dfs(String departure) {
		
		PriorityQueue<String> arrivals = flights.get(departure);
		
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll()); // remmber  - we are removing the aiport from its destinations.			
		}
		
		// I will add departure only after all the destinations are covered.
		path.addFirst(departure);
	}

}
