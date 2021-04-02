/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 1026 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaxDifferenceBtwnNodeAndAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Integer result = Integer.MIN_VALUE; // result

	// Its not a BST, just a binary tree
	public int maxAncestorDiff(TreeNode root) {
		if (root == null)
			return 0;

		util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return result;

	}

	private void util(TreeNode root, int maxValue, int minValue) {

		if (root == null)
			return;

		maxValue = Math.max(maxValue, root.val);
		minValue = Math.min(minValue, root.val);

		result = Math.max(result, Math.max(Math.abs(maxValue - root.val), Math.abs(minValue - root.val)));

		util(root.left, maxValue, minValue);
		util(root.right, maxValue, minValue);
	}

}
