/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 669 :
 * 
 * Date : Dec 27, 2020
 * 
 * @author bramanarayan
 *
 */
public class TrimBSTInRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// delete all the nodes in BST in a given range. you should not change the
	// structure of the original tree
	public TreeNode trimBST(TreeNode root, int low, int high) {

		if (root == null)
			return root;

		if (root.val < low) {
			return trimBST(root.right, low, high); // delete only on right side
		}
		if (root.val > high) {
			return trimBST(root.left, low, high); // delete only on left side
		}
		// the root node is in the range.
		root.left = trimBST(root.left, low, high); // delete on both the sides
		root.right = trimBST(root.right, low, high);

		return root;
	}

}
