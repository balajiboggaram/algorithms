package me.learn.personal.month2;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Title 120 : Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], 
 * 	[3,4], 
 * 	[6,5,7], 
 * [4,1,8,3] ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class TraingleMinimum {
	
	
	public static void main(String ags[]) {

		TraingleMinimum solution = new TraingleMinimum();
		solution.minimumTotal(Arrays.asList(Arrays.asList(2), 
				Arrays.asList(3,4), 
				Arrays.asList(6,5,7), 
				Arrays.asList(4,1,8,3)));

	}

	/**
	 * Clean dynamic programming problem
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size(); // number of rows
		int[] dp = new int[m];
		
		// copy the last row of triangle in to dp
		for(int i =0;i< triangle.get(m-1).size();i++) {
			dp[i] = triangle.get(m-1).get(i);
		}
		
		// Once you copied, You got the base for DP. So Lets proceed
		for(int i = m-2;i>=0;i--) {
			for(int j = 0 ;j <= i ;j++) {
				dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
			}
		}
		System.out.println(dp[0]);
		return dp[0];
		
	}
}
