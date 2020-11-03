
package me.learn.personal.month2;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title 1122 :
 * 
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2. Elements that don't appear in arr2 should be placed
 * at the end of arr1 in ascending order.
 * 
 * Example 1:
 * 
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] Output:
 * [2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * @author bramanarayan
 * @date Jun 7, 2020
 */
public class RelativeSortArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RelativeSortArray solution = new RelativeSortArray();
		solution.relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 });
		solution.relativeSortArray(new int[] { 28, 6, 22, 8, 44, 17 }, new int[] { 22, 28, 8, 6 });

	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;

		if (n > m)
			return null;

		// Dictionary of arr1
		ConcurrentHashMap<Integer, Integer> cMap = new ConcurrentHashMap<>();
		for (int i = 0; i < m; i++) {
			cMap.put(arr1[i], cMap.getOrDefault(arr1[i], 0) + 1);
		}

		int k = 0;
		for (int i = 0; i < n; i++) {
			if (cMap.containsKey(arr2[i])) {
				// Add elements to result
				order(arr1, arr2[i], cMap.get(arr2[i]), k);
				k += cMap.get(arr2[i]);
				cMap.remove(arr2[i]);
			}
		}

		// Add the remaining elements in SORTED order
		TreeMap<Integer, Integer> tMap = new TreeMap<Integer, Integer>(cMap);
		for (Entry<Integer, Integer> e : tMap.entrySet()) {
			order(arr1, e.getKey(), e.getValue(), k);
			k += e.getValue();
		}
		System.out.println(Arrays.toString(arr1));
		return arr1;
	}

	private void order(int[] arr1, int value, int count, int k) {
		for (int i = 0; i < count; i++) {
			arr1[k] = value;
			k++;
		}
	}
}