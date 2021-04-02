/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 110 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class IsBalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean result = true;

	public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return result;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		if (Math.abs(l - r) > 1)
			result = false;
		return 1 + Math.max(l, r);
	}

	//Ignore 
	public boolean isBalanced1(TreeNode root, Integer height) {
		if (root == null)
			return true;

		Integer leftHeight = 0;
		Integer rightHeight = 0;

		boolean isLeft = isBalanced1(root.left, leftHeight);
		boolean isRight = isBalanced1(root.right, rightHeight);

		height = Math.max(leftHeight, rightHeight) + 1;

		return isLeft && isRight && Math.abs(leftHeight - rightHeight) <= 1;
	}
}
