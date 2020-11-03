/**
 * 
 */
package me.learn.personal.month3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title 767 :
 * 
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba"
 * 
 * Example 2:
 * 
 * Input: S = "aaab" Output: ""
 * 
 * Note:
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * 
 * @author bramanarayan
 * @date Jul 3, 2020
 */
public class ReorganizeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// GREEDY
	// HASH
	// HEAP SORT
	public String reorganizeString(String s) {

		int n = s.length();
		
		// Compute all the frequencies of the characters
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			if(map.get(c) > (n+1)/2) 
				return "";
		}

		// Put them in the priority queue
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		map.entrySet().forEach(x -> pq.add(new Tuple(x.getValue(), x.getKey())));

		
		// IMPORTANT STEP here - can be applied to other problem to 
		// retrieve based on frequency - non overlapping kind of problems
		// Try to fetch them in order of frequencies
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty() && pq.size() > 1) {
			Tuple t1 = pq.remove();
			Tuple t2 = pq.remove();

			sb.append(t1.c);
			sb.append(t2.c);

			t1.count--;
			t2.count--;

			if (t1.count > 0) {
				pq.add(t1);
			}

			if (t2.count > 0) {
				pq.add(t2);
			}
		}
		
		// Handle if the pq has only one element with frequency 1.
		if(pq.size() > 0) sb.append(pq.poll().c); // if there is a last character
		
		if(pq.size() > 1 ) return "";
	
		return sb.toString();

	}
}

class Tuple implements Comparable<Tuple> {
	int count;
	char c;

	public Tuple(int count, char c) {
		this.count = count;
		this.c = c;
	}

	// ascending - other - mine
	@Override
	public int compareTo(Tuple o) {
		return o.count - this.count;
	}

}
