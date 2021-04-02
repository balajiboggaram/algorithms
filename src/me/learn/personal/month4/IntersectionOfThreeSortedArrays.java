/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Title 1213 : 
 * 
 * Given three integer arrays arr1, arr2 and arr3 sorted in
 * strictly increasing order, return a sorted array of only the integers that
 * appeared in all three arrays.
 * 
 * Example 1:
 * 
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8] Output:
 * [1,5] Explanation: Only 1 and 5 appeared in the three arrays.
 * 
 * Constraints:
 * 
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000 1 <= arr1[i], arr2[i],
 * arr3[i] <= 2000
 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class IntersectionOfThreeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IntersectionOfThreeSortedArrays solution = new IntersectionOfThreeSortedArrays();
		solution.arraysIntersection(new int[] {1,2,3,4,5},new int[] {1,2,5,7,9},new int[] {1,3,4,5,8});
	}
		
	// You can just implement this with three simple i j and k pointers. 
	// The question description can be imporoved. especially on length etc.
	public List<Integer> arraysIntersection(int[] a1, int[] a2, int[] a3) {

		Map<Integer, Integer> a1Count = new HashMap<>();
		Map<Integer, Integer> a2Count = new HashMap<>();
		List<Integer> res = new ArrayList<Integer>();

		for (int x : a1) {
			a1Count.put(x, a1Count.getOrDefault(x, 0) + 1);
		}

		for (int x : a2) {
			a2Count.put(x, a2Count.getOrDefault(x, 0) + 1);
		}

		for (int x : a3) {
			if (a1Count.containsKey(x) && a2Count.containsKey(x)) {
				res.add(x);
				a1Count.put(x, a1Count.get(x) - 1);
				a2Count.put(x, a2Count.get(x) - 1);

				if (a1Count.get(x) == 0)
					a1Count.remove(x);
				if (a2Count.get(x) == 0)
					a2Count.remove(x);

			}
		}
		return res;
	}

}
