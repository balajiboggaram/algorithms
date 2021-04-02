/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Title 239 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SlidingWindowMaximum solution = new SlidingWindowMaximum();
		// System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] { 1,
		// 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] { 1, 1, 1, 3 }, 3)));

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (k > nums.length)
			return new int[] {};

		int n = nums.length;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		int[] result = new int[n - k + 1];
		int index = 0;
		for (int i = 0; i < n; i++) {
			pq.add(nums[i]);
			if (pq.size() == k) {
				// fetch max
				result[index] = pq.peek();
				index++;
				pq.remove(nums[i - k + 1]);
			}
		}
		return result;
	}
	
	// OR 
	// O(n) solution 
	
	public int[] maxSlidingWindowBEST(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int resultIndex = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[resultIndex++] = a[q.peek()];
			}
		}
		return r;
	}
	

}
