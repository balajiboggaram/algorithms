/**
 * 
 */
package me.learn.personal.month7;

import java.util.PriorityQueue;

/**
 * Title 1696:
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class JumpGameAllowedKStepsEachTime {

	/**
	 * Its a pure DP problem.
	 * 
	 * At any given step i. you check max value obtained from 'i-k' to 'i-1' number
	 * of steps back of i
	 * 
	 * so, maintain a priority queue for storing these 'i-k' to 'i-1' number of
	 * steps.
	 * 
	 * the peek() of PQ should give us the answer every time.,
	 * 
	 * keep popping all the elements which are less than 'i-k' from PQ
	 */
	public int maxResult(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0]; // k >=1
		
		PriorityQueue<CEntry> maxHeap = new PriorityQueue<JumpGameAllowedKStepsEachTime.CEntry>();
		
		// add the first element value and index 0 as init
		maxHeap.add(new CEntry(nums[0],0));

		for (int i = 1; i < nums.length; i++) {
			while (!maxHeap.isEmpty() && maxHeap.peek().index < (i - k)) {
				maxHeap.remove();
			}
			dp[i] = nums[i] + maxHeap.peek().maxValue;
			maxHeap.add(new CEntry(dp[i], i));
		}
		return dp[nums.length - 1];
	}
	
	class CEntry implements Comparable<CEntry>{
		
		int maxValue ;
		int index;
		
		CEntry(int value , int index) {
			this.maxValue = value;
			this.index = index;
		}

		@Override
		public int compareTo(CEntry o) {
			return o.maxValue - this.maxValue;
		}
	}

}
