/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 456 :
 * 
 *   Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:

Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.

Example 2:

Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:

Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class Pattern132 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern132 solution = new Pattern132();
		System.out.println(solution.find132pattern(new int[] {3,1,4,2}));
		System.out.println(solution.find132pattern(new int[] {1,0,1,-4,-3}));
		System.out.println(solution.find132pattern(new int[] {3,5,0,3,4}));

	}
	
	 public boolean find132pattern(int[] nums) {
	        if (nums.length < 3)
	            return false;
	        int[] min = new int[nums.length];
	        min[0] = nums[0];
	        for (int i = 1; i < nums.length; i++)
	            min[i] = Math.min(min[i - 1], nums[i]);
	        int k = nums.length;
	        for (int j = nums.length - 1; j >= 0; j--) {
	            if (nums[j] > min[j]) {
	            	
	            	// find a k
	                while (k < nums.length && nums[k] <= min[j])
	                    k++;
	                
	                if (k < nums.length && nums[k] < nums[j])
	                    return true;
	                
	                nums[--k] = nums[j];
	            
	            }
	        }
	        return false;
	 }

	// Compute L->R mins (only indexes please)
	// Compute L-R maxs (only indexes please)
	// then compare current index with min and max with few conditions
	public boolean find132patternMy(int[] nums) {

		int n = nums.length;
		int[] min = new int[n];
		int[] max = new int[n];
		
		// compute min's
		for (int i = 1; i < n; i++) {
			min[i] = nums[i] < nums[min[i-1]] ? i : min[i-1];
		}
		
		// compute max's
		for (int i = 1; i < n; i++) {
			max[i] = nums[i] > nums[max[i-1]] ? i : max[i-1];
		}
		
		// check if our condition exists
		for(int i =0;i<n;i++) {
			if(i > min[i] && i > max[i] && nums[i] > nums[min[i]] && nums[i] < nums[max[i]] && min[i] < max[i])
				return true;
		}
		
		return false;
	}

}
