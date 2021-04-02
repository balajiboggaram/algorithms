/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title 1636 : 
 * 
 * Date : Jan 30, 2021
 * 
 * @author bramanarayan
 *
 */
public class SortArrayByIncreasingFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Other way is to use Tuple and Priority Queue based solution
	
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		// count frequency of each number
		Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
		// custom sort
		return Arrays.stream(nums).boxed()
				.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
				.mapToInt(n -> n)
				.toArray();
	}


}
