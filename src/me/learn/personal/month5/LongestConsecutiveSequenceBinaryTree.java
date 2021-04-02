/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 298 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class LongestConsecutiveSequenceBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	Integer result = 0;

	public int longestConsecutive(TreeNode root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		util(root, 0, root.val);
		return result;
	}

	private void util(TreeNode root, Integer length, Integer target) {

		if (root == null)
			return;

		if (root.val == target)
			length++;
		else
			length = 1;

		result = Math.max(result, length);

		util(root.left, length, root.val + 1);
		util(root.right, length, root.val + 1);

	}

}
