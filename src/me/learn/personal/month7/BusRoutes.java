/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Title 815 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class BusRoutes {

	// each route[] contains list of bus stops that route 'i' stops at
	public int numBusesToDestination(int[][] routes, int source, int destination) {
		if (source == destination)
			return 0;

		Set<Integer> usedBuses = new HashSet<>();

		// ENTRY : busStop -> List of Routes
		Map<Integer, List<Integer>> stopToRoutes = new HashMap<>(); // {route: [buses]}

		for (int i = 0; i < routes.length; i++) {
			for (int route : routes[i]) {
				stopToRoutes.putIfAbsent(route, new ArrayList<>());
				stopToRoutes.get(route).add(i);
			}
		}

		int routesCount = 0;
		Queue<Integer> q = new LinkedList<>(Arrays.asList(source)); // list of bus stops

		while (!q.isEmpty()) {
			routesCount++;
			int size = q.size();
			for (int i = 0; i < size; i++) {

				for (int route : stopToRoutes.get(q.poll())) { // get all the routes at given bus stop

					if (usedBuses.add(route)) { // if the route is not traversed before, then add it
						for (int busStop : routes[route]) // take all new busstops yet to visit
							if (busStop == destination)
								return routesCount;
							else
								q.offer(busStop);
					}
				}
			}
		}

		return -1;
	}
}
