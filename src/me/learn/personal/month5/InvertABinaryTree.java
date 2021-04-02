/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 226 :
 * 
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 4 / \ 2 7 / \ / \ 1 3 6 9
 * 
 * Output:
 * 
 * 4 / \ 7 2 / \ / \ 9 6 3 1
 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class InvertABinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}
}
