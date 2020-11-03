/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Title 461 :
 * 
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together.
 * 
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class SortCharactersByFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortCharactersByFrequency solution = new SortCharactersByFrequency();
		System.out.println(solution.frequencySort("tree"));
		System.out.println(solution.frequencySort("cccaa"));

	}

	// Heap + kk
	// n [log k] , where k is the number of unique elements.
	public String frequencySort(String s) {

		// prepare a frequency map
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (char c : s.toCharArray())
			m.put(c, m.getOrDefault(c, 0) + 1);

		PriorityQueue<CKEntry1> pq = new PriorityQueue<>();
		for (Entry<Character, Integer> e : m.entrySet()) {
			pq.add(new CKEntry1(e.getKey(), e.getValue()));
		}
		
		// prepare the output now
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			CKEntry1 temp = pq.poll();
			char[] tempC = new char[temp.count];
			Arrays.fill(tempC, temp.c); // repeat c count' times
			sb.append(tempC);
		}
		
		return sb.toString();

	}

}

class CKEntry1 implements Comparable<CKEntry1> {

	char c;
	int count;

	public CKEntry1(char c, int count) {
		this.c = c;
		this.count = count;
	}

	@Override
	public int compareTo(CKEntry1 o) {
		return o.count - this.count; // descending order
	}

}
