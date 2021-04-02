/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Title 698 :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class PartitionProblemKEqualSumSubSet {
	
	// Based on backtrackign
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
	
		// compute sum
		for (int n : nums)
			sum += n;
		
		// can divide to k parittions ?
		if (sum % k != 0)
			return false;
		
		if (nums.length < k)
			return false;

		boolean[] used= new boolean[nums.length];
		return canPartition(nums, used, 0, k, 0, sum / k);
	}

	private boolean canPartition(int[] nums, boolean[] used, int start, int k, int curSum, int subSum) {
		
		if (k == 1)
			return true;
		
		if (curSum > subSum)
			return false;
		
		if (curSum == subSum)
			return canPartition(nums, used, 0, k - 1, 0, subSum); /// search only for k-1 partitions now

		for (int i = start; i < nums.length; i++) {
			
			if (used[i])
				continue;
			
			used[i] = true;
			
			if (canPartition(nums, used, i + 1, k, curSum + nums[i], subSum))
				return true;
			
			used[i] = false;
		}

		return false;
	}
}
