/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title :
 * 
 * Date : Feb 28, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumPatchesRequired {

	// how many to add so that, the combi sum will have all numbers starting from 1 to n.
	int minPatches(int[] nums, int n) {
		
		long sum = 0;
		int i = 0, patch = 0;

		while (sum < n) { // sum -> 1,2,3,4,5,......n
			
			// if sum --> (a[i] + 1). At this point
			if (i >= nums.length || sum + 1 < nums[i]) {
				patch += 1; // add one more number here. this is the critical point where you are increasing the boundary
				sum = sum + (sum + 1);
			} else {
				sum = sum + nums[i];  // here sum is greater than nums[i]
				i++;
			}
		
		}

		return patch;
	}
}
