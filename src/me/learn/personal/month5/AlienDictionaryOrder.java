/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Title 269 :
 * 
 * Date : Jan 9, 2021
 * 
 * @author bramanarayan
 *
 */
public class AlienDictionaryOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String alienOrder(String[] words) {
		
		
		Map<Character, Set<Character>> neighbor = new HashMap<>(); // like edges or adjacency list graph
		
		Map<Character, Integer> inDegree = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		
		return buildGraph(words, neighbor, inDegree) && topo(neighbor, inDegree, sb) ? sb.toString() : "";
	}

	private boolean buildGraph(String[] words, Map<Character, Set<Character>> neighborMap,
			Map<Character, Integer> degree) {

		for (int i = 0; i < words.length; i++) {
			
			String w1 = words[i], w2 = words[i + 1];


			// current word
			for (char c : words[i].toCharArray()) {
				neighborMap.putIfAbsent(c, new HashSet<>());
			}

			// find relationship between word pairs
			if (i == words.length - 1) {
				break;
			}
			

			// second word shorter than first word with same prefix is invalid ex. "abc",
			// "ab"
			if (w2.length() < w1.length() && w1.substring(0, w2.length()).equals(w2)) {
				return false;
			}

			// only first different matters
			int len = Math.min(w1.length(), w2.length());
			
			for (int j = 0; j < len; j++) {
			
				char c1 = w1.charAt(j), c2 = w2.charAt(j);
				
				if (c1 != c2) {
				
					neighborMap.get(c1).add(c2);
					degree.put(c2, degree.getOrDefault(c2, 0) + 1);
					break;
				}
			}

		}
		return true;
	}

	private boolean topo(Map<Character, Set<Character>> neighbor, Map<Character, Integer> degree, StringBuilder sb) {

		Queue<Character> q = new ArrayDeque<>();
		
		// put all the characters with indegree 0, iterate on keyset of neighbors
		for (char ch : neighbor.keySet()) {
			if (!degree.containsKey(ch) || degree.get(ch) == 0) {
				q.offer(ch);
				sb.append(ch);
			}
		}

		while (!q.isEmpty()) {

			char c = q.poll();

			// process all the neighbors of 'c'
			if (neighbor.containsKey(c)) {
				
				for (char next : neighbor.get(c)) {
					degree.put(next, degree.get(next) - 1);
					if (degree.get(next) == 0) {
						q.offer(next);
						sb.append(next);
					}
				}
			}
		}
		// check loop
		return sb.length() == neighbor.size();
	}

}
