/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 1038 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class BSTToGreaterSumTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree
	 * such that every key of the original BST is changed to the original key plus
	 * sum of all keys greater than the original key in BST.
	 */
	public TreeNode bstToGst(TreeNode root) {

		if (root == null)
			return null;
		return util(root);
	}

	// reverse post
	int sum = 0; // if ever you want to send the state of node to up, keep it as global for their access
	TreeNode util(TreeNode root) {
		if (root == null)
			return null;
		root.right = util(root.right);
		sum = sum + root.val;
		root.val = sum;
		root.left = util(root.left);
		return root;
	}

}
