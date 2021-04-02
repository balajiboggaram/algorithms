/**
 * 
 */
package me.learn.personal.month7;

import me.learn.utli.TreeNode;

/**
 * Title 99 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class RecoverBinaryTree {

	TreeNode firstNode = null;
	TreeNode secondNode = null;

	// The reason for this initialization is to avoid null pointer exception in the
	// first comparison when prevElement has not been initialized
	TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap ONLY ONCE - two nodes
		int temp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = temp;
	}

	private void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// FIrst violation
		if (firstNode == null && prevNode.val >= root.val) {
			firstNode = prevNode;
		}

		// second VIOLATION
		if (firstNode != null && prevNode.val >= root.val) {
			secondNode = root;
		}
		prevNode = root;

		// End of "do some business"
		traverse(root.right);
	}
}
