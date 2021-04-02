/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 250 :
 * 
 * Date : Dec 27, 2020
 * 
 * @author bramanarayan
 *
 */
public class CountUniValueSubtrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// A univalue subtree will have all the nodes of subtree with same value in it.
	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		helper(root);
		return count;
	}

	boolean helper(TreeNode root) {
		if (root == null)
			return true;

		boolean left = helper(root.left);
		boolean right = helper(root.right);

		if (left && right && 
				(root.left == null || root.val == root.left.val) && 
				(root.right == null || root.val == root.right.val)) {
			count++;
			
			return true;
		}

		return false;
	}

}
