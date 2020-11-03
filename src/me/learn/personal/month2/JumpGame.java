/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 55  : 
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 * 
 * @author bramanarayan
 * @date Jun 9, 2020
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JumpGame solution = new JumpGame();
		System.out.println(solution.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(solution.canJump(new int[] { 3,2,1,0,4 }));
		System.out.println(solution.canJump(new int[] { 2,0 }));
		System.out.println(solution.canJump(new int[] { 2,0,0 }));
		System.out.println(solution.canJump(new int[] { 3,0,8,2,0,0,1 }));

	}

	
	// Basically, keep a variable 'max' to track how far can you jump
	// from so far traversed elements. 
	
	// if at any point, if the max is less the i -> you can never reach end.
	// else -> you can always reach end.
	public boolean canJump(int[] nums) {
		int n = nums.length;
		if(n == 1 ) return true;

		int max = nums[0];

		for (int i = 1; i < n; i++) {
			if (max < i)
				return false;
			else {
				max = Math.max(max, i + nums[i]);
			}
		}
		return true;
	}

}
