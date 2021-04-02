/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 746 :
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 * 
 * Example 1:
 * 
 * Input: cost = [10, 15, 20] Output: 15 Explanation: Cheapest is start on
 * cost[1], pay that cost and go to the top.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jun 15, 2020
 */
public class MinCostClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// DYNAMIC PROGRAMMING
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;

		int[] dp = new int[n];
		dp[0] = cost[0];
		dp[1] = cost[1];

		// dp[i] = Minimum(dp[i-1] , dp[i-2]) + cost[i]
		for (int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
		}

		// Now return minimum of last two, Because the person can start either from
		// first step or last step. Which indirectly means he will end up either in
		// last step or last-1 step.
		return Math.min(dp[n - 1], dp[n - 2]);
	}

}
