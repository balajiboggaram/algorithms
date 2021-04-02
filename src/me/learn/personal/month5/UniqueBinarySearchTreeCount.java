/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 96 :
 * 
 *  Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 

Constraints:

    1 <= n <= 19
 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class UniqueBinarySearchTreeCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTrees(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for( int j = 1; j < i ; j++) {
				// the below is the cartesian product. remember. its all about m *n combinations
				dp[i] = dp[i] + dp[j-1] * dp[i-j];  
			}
		}
		return dp[n];

	}

}
