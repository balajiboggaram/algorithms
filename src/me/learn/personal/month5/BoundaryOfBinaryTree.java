/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 545 :
 * 
 * A binary tree boundary is the set of nodes (no duplicates) denoting the union
 * of the left boundary, leaves, and right boundary.
 * 
 * The left boundary is the set of nodes on the path from the root to the
 * left-most node. The right boundary is the set of nodes on the path from the
 * root to the right-most node.
 * 
 * The left-most node is the leaf node you reach when you always travel to the
 * left subtree if it exists and the right subtree if it doesn't. The right-most
 * node is defined in the same way except with left and right exchanged. Note
 * that the root may be the left-most and/or right-most node.
 * 
 * Given the root of a binary tree, return the values of its boundary in a
 * counter-clockwise direction starting from the root.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [1,null,2,3,4] Output: [1,3,4,2] Explanation: The left boundary
 * is the nodes [1,2,3]. The right boundary is the nodes [1,2,4]. The leaves are
 * nodes [3,4]. Unioning the sets together gives [1,2,3,4], which is [1,3,4,2]
 * in counter-clockwise order.
 * 
 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class BoundaryOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> result = new ArrayList<>(1000);

	// MAIN METHOD
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {

		if (root == null)
			return result;

		result.add(root.val);
		
		
		leftBoundary(root.left);
		
		leaves(root.left); // Get leaves from the left subtree
		leaves(root.right); // Get leaves from the right subtree
		
		rightBoundary(root.right);

		return result;
	}

	public void leftBoundary(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		result.add(root.val);
		if (root.left == null)
			leftBoundary(root.right);
		else
			leftBoundary(root.left);
	}

	public void rightBoundary(TreeNode root) {
		if (root == null || (root.right == null && root.left == null))
			return;
		if (root.right == null)
			rightBoundary(root.left);
		else
			rightBoundary(root.right);
		// this is a nice one
		result.add(root.val); // add after child visit(reverse)
	}

	public void leaves(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		leaves(root.left);
		leaves(root.right);
	}
}
