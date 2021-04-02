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
 * Title 207 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class CanFinishCourseSchedule {

	/**
	 * There are a total of numCourses courses you have to take, labeled from 0 to
	 * numCourses-1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you have to
	 * first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true Explanation:
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0. So it is possible.
	 * 
	 * Example 2:
	 * 
	 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false
	 * Explanation: There are a total of 2 courses to take. To take course 1 you
	 * should have finished course 0, and to take course 0 you should also have
	 * finished course 1. So it is impossible.
	 * 
	 * 
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// check if you can finish all the courses in a given schedule
	// pre-req -> [0,1] ------> Indicates 1 is pre-erq for 0 course
	// n -> total # of courses

	// I think we need to just detect a cycle(deadlock) exists.
	// if it does, then you cannot finish the course schedule. its a pure graph
	// theory problem
	// lets solve this by converting to a graph
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        
		Map<Integer, List> map = new HashMap<>(); // graph
		Map<Integer, Integer> inDegree = new HashMap<>();

		// initialize the graph and indegrees
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}

		// Now, update the graph and indegree maps
		for (int[] edge : prerequisites) {
			int from = edge[1];
			int to = edge[0];
			map.get(from).add(to); // i am dependent for whom ?
			inDegree.put(to, inDegree.get(to) + 1);
		}

		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<>();

		// add the seed to BFS queue now. Pick any node with indegree 0.
		// if we cannot find any node with indegree 0, then - THIS GRAPH DEFINITELY HAS
		// A CYCLE IN IT.
		for (int key : inDegree.keySet()) {
			if (inDegree.get(key) == 0) {
				queue.offer(key);
				result.add(key);
			}
		}

		// If there is no cycle, proceed with BFS to get topological sort
		while (!queue.isEmpty()) {
			int node = queue.poll();

			List<Integer> neigh = map.get(node);

			for (int neighbor : neigh) {
				//if(result.contains(neighbor)) return new int[0];

				inDegree.put(neighbor, inDegree.get(neighbor) - 1); // decrement one piercing edge to neighbor

				// we add to result only when indegree is 0. that means all its dependencies are
				// completed
				if (inDegree.get(neighbor) == 0) {
					result.add(neighbor);
					queue.offer(neighbor); // I can mark myself done, SInce I am dependent for my children, so that my
											// children can start their job
				}
			}

		}

		
		// This is very important. if we not finished all the courses. Then there is a cycle for sure. 
		// Basically,if there is no cycle - queue should always contain a node with indegree 0 untill all nodes are completed. trace the input from main
		return result.size() == numCourses; // s
    
}

}
