package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 
 * Title 215 :
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 * 
 * @author bramanarayan
 * @date Jul 18, 2020
 */
public class KthLargestElementArray {

	public static void main(String args[]) {
		KthLargestElementArray solution = new KthLargestElementArray();
		System.out.println(solution.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
		System.out.println(solution.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));

	}

	// Min HEAP + kk
	// o[n log k]
	// Can also do this using quickselect algorithm
	public int findKthLargest(int[] nums, int k) {

		// min heap - for largest always
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.add(num);
			// always maintain a heap of size k
			if (pq.size() > k) {
				pq.remove();
			}
		}

		return pq.peek();
	}

}
