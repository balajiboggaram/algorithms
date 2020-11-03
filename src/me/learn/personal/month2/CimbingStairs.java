/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 70 : 
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

 * 
 * @author bramanarayan
 * @date Jun 15, 2020
 */
public class CimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CimbingStairs solution = new CimbingStairs();
		System.out.println(solution.climbStairs(3));
		System.out.println(solution.climbStairs(2));

	}

	// DYNAMIC PROGRAMMING
	public int climbStairs(int n) {
		
		// if only one step, there is only one possible way
		if(n==1) return 1;
		
		
		// DP init
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		
		// DP Formula = dp(i) = dp(i-1) +  dp(i-2) + 1
		// i.e # of ways to reach i-1 step + # of ways to reach i-2 step 
		
		for(int i = 2;i< n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n-1];
	}

}
