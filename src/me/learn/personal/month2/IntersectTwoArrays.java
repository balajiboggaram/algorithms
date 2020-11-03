package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Title 350 : Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2]
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9]
 * 
 * Note:
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays. The result can be in any order.
 * 
 * Follow up:
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm? What if nums1's size is small compared to nums2's size? Which
 * algorithm is better? What if elements of nums2 are stored on disk, and the
 * memory is limited such that you cannot load all elements into the memory at
 * once?
 * 
 * 
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class IntersectTwoArrays {

	public static void main(String args[]) {
		IntersectTwoArrays solution = new IntersectTwoArrays();
		solution.intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 });
		int[] res = solution.intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
		System.out.println(Arrays.asList(res));
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < m; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums2[i]) && (map.get(nums2[i]) > 0)) {
				res.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}

}
