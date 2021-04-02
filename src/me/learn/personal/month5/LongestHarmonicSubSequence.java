/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 594 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class LongestHarmonicSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// the definition of harmonic subsequence is that the difference between the
	// elements of array MUST BE EXACTLy 1.
	// Find the longest such subsequence.

	// just put the count in a map. And see successive diff of map and keep updating
	// the result
	public int findLHS(int[] a) {

		Map<Integer, Integer> map = new HashMap<>();
		Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

		int result = 0;
		for (Entry<Integer, Integer> e : map.entrySet()) {
			int key = e.getKey();

			// lower check
			if (map.get(key - 1) != null) {
				result = Math.max(e.getValue() + map.get(key - 1), result);
			}

			// higher check
			if (map.get(key + 1) != null) {
				result = Math.max(e.getValue() + map.get(key + 1), result);
			}

		}
		return result;
	}

}
