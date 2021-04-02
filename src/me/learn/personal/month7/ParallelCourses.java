/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Title :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class ParallelCourses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// HOW 
	public int minimumSemesters(int N, int[][] relations) {
		Map<Integer, List<Integer>> adjMap = new HashMap<>(); // key: prerequisite, value: course list.
		
		
		
		int[] inDegree = new int[N + 1]; // inDegree[i]: number of prerequisites for i.
		for (int[] r : relations) {
			adjMap.computeIfAbsent(r[0], l -> new ArrayList<>()).add(r[1]); // construct graph.
			//indegree.put(r[1], indegree.getOrDefault(r[1], 0) + 1);
			++inDegree[r[1]]; // count prerequisites for r[1].
		}
		
		
		// Add all the ones with indegree as 0
		Queue<Integer> q = new LinkedList<>(); // save current 0 in-degree vertices.
		for (int i = 1; i <= N; ++i)
			if (inDegree[i] == 0)
				q.offer(i);
		
		
		int semesterCount = 0;
	
		while (!q.isEmpty()) { // BFS traverse all currently 0 in degree vertices.
			for (int sz = q.size(); sz > 0; --sz) { // sz is the search breadth.
				int c = q.poll();
				--N;
				if (!adjMap.containsKey(c))
					continue; // c's in-degree is currently 0, but it has no prerequisite.
				for (int course : adjMap.remove(c))
					
					
					if (--inDegree[course] == 0) // decrease the in-degree of course's neighbors.
						q.offer(course); // add current 0 in-degree vertex into Queue.
			}
			++semesterCount; // need one more semester.
		}
		return N == 0 ? semesterCount : -1;
	}
}
