/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 979 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class DistributeCoinsInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;

	// Distribute coins (node.val) to others such that every node has exactly one
	// coin;
	// its noted that number of coins in tree is exactly equal to number of nodes in
	// tree.
	public int distributeCoins(TreeNode root) {
		util(root);
		return result;

	}

	private int util(TreeNode root) {

		if (root == null)
			return 0;
		int left = util(root.left);
		int right = util(root.right);

		// abs is required here as left may have excess or lack coins (excess - positive, lack - negative)
		result = result + Math.abs(left) + Math.abs(right);

		return root.val + left + right - 1;
	}

}
