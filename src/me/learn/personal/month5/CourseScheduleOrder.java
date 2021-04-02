/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Title 210 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class CourseScheduleOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CourseScheduleOrder solution = new CourseScheduleOrder();
		System.out.println(Arrays.toString(solution.findOrder(3, new int[][] { { 1, 0 }, { 1, 2 }, { 0, 1 } })));

	}

	// TOPOOGICAL TEMPLATE
	// TOPO WITH BFS
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> map = new HashMap<>(); // graph
		Map<Integer, Integer> inDegree = new HashMap<>();

		// initialize the graph and indegrees
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}

		// Now, update the graph and indegree maps
		for (int[] edge : prerequisites) {
			int from = edge[1]; // parent
			int to = edge[0]; // child
			map.get(from).add(to); // i am dependent to whom ?
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
		return result.size() != numCourses ? new int[0] : result.stream().mapToInt(i -> i).toArray(); // since return type is int[] array
	}

}
