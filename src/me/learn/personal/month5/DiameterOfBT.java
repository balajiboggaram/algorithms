/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 543 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class DiameterOfBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		util(root);
		return result - 1;
	}

	private int util(TreeNode root) {
		if (root == null)
			return 0;

		int ld = util(root.left);
		int rd = util(root.right);

		result = Math.max(ld + rd + 1, result);

		return Math.max(ld, rd) + 1;

	}

}
