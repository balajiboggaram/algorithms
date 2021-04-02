/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 509 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class FibonacciNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FibonacciNumber solution = new FibonacciNumber();
		System.out.println(solution.fib(3));
	}

	public int fib(int n) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		if( n ==2 ) return 1;
		
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n-1];

	}

}
