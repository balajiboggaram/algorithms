/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Title 126 :
 * 
 * Date : Feb 28, 2021
 * 
 * @author bramanarayan
 *
 */
public class WordLadder2ReturnAllShortestPaths {

	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
		
		HashSet<String> wordSet = new HashSet<String>(wordList);
		
		List<List<String>> res = new ArrayList<List<String>>();
		
		HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
	
		
		HashMap<String, Integer> distanceMap = new HashMap<String, Integer>();// Distance of every node from the start node
		ArrayList<String> solution = new ArrayList<String>();

		// STEP 1 : Find shortest length
		wordSet.add(start);
		bfs(start, end, wordSet, nodeNeighbors, distanceMap); // prepares the levelMap and nodeNeighbors which is crucial
		
		// STEP 2 : Perform DFS up to 
		dfs(start, end, wordSet, nodeNeighbors, distanceMap, solution, res);
		return res;
	}

	// BFS: Trace every node's distance from the start node (level by level).
	private void bfs(String start, String end, Set<String> wordSet, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distanceMap) {
		
		for (String str : wordSet)
			nodeNeighbors.put(str, new ArrayList<String>()); // init to empty neighbor set
	
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		distanceMap.put(start, 0);

		while (!queue.isEmpty()) {
			int count = queue.size();
			boolean foundEnd = false;
			
			// each level
			for (int i = 0; i < count; i++) {
				String cur = queue.poll();
				int curDistance = distanceMap.get(cur); // how far is cur node from source. this will be shortest as we do BFS
				
				ArrayList<String> neighbors = getNeighbors(cur, wordSet); // contains both parent and children

				for (String neighbor : neighbors) {
					nodeNeighbors.get(cur).add(neighbor); // add the neighbor(parent or child) to current word

					if (!distanceMap.containsKey(neighbor)) {// Check if visited
						distanceMap.put(neighbor, curDistance + 1);
						if (end.equals(neighbor)) { // Found the shortest path
							foundEnd = true;
						} else {
							queue.offer(neighbor);
						}
					} // end of distance map manipulation
				}
			}

			if (foundEnd)
				break;
		}
	}

	// Find all next level nodes.
	private ArrayList<String> getNeighbors(String node, Set<String> wordSet) {
		ArrayList<String> res = new ArrayList<String>();
		char chs[] = node.toCharArray();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] == ch)
					continue;
				char oldCh = chs[i];
				chs[i] = ch;
				if (wordSet.contains(String.valueOf(chs))) {
					res.add(String.valueOf(chs));
				}
				chs[i] = oldCh;
			}

		}
		return res;
	}

	// DFS: output all paths with the shortest distance.
	private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> curSolution, List<List<String>> res) {
		curSolution.add(cur);
		if (end.equals(cur)) {
			res.add(new ArrayList<String>(curSolution));
		} else {
			for (String next : nodeNeighbors.get(cur)) {
				if (distance.get(next) == distance.get(cur) + 1) {
					dfs(next, end, dict, nodeNeighbors, distance, curSolution, res);
				}
			}
		}
		curSolution.remove(curSolution.size() - 1);
	}

}
