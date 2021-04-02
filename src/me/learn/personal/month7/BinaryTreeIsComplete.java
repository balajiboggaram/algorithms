/**
 * 
 */
package me.learn.personal.month7;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title :
 * 
 * Date : Feb 16, 2021
 * 
 * @author bramanarayan
 *
 */
public class BinaryTreeIsComplete {

	/* This function counts the number of nodes in a binary tree */
	int countNodes(TreeNode root) {
		if (root == null)
			return (0);
		return (1 + countNodes(root.left) + countNodes(root.right));
	}

	/*  MAIN one. This function checks if the binary tree is complete or not */
	boolean isComplete(TreeNode root, int index, int number_nodes) {
		// An empty tree is complete
		if (root == null)
			return true;

		// If index assigned to current node is more than
		// number of nodes in tree, then tree is not complete
		if (index >= number_nodes)
			return false;

		// Recur for left and right subtrees
		return (isComplete(root.left, 2 * index + 1, number_nodes)
				&& isComplete(root.right, 2 * index + 2, number_nodes));

	}

	// OR -> using BFS below

	/*
	 * Given a binary tree, return true if the tree is complete else false
	 */
	static boolean isCompleteBT(TreeNode root) {
		// Base Case: An empty tree is complete Binary Tree
		if (root == null)
			return true;

		// Create an empty queue
		Queue<TreeNode> queue = new LinkedList<>();

		// Create a flag variable which will be set true
		// when a non full node is seen
		boolean flag = false;

		// Do level order traversal using queue.
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp_node = queue.remove();

			/* Check if left child is present */
			if (temp_node.left != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty left child, then the given tree is not
				// a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Left Child
				queue.add(temp_node.left);
			}
			// If this a non-full node, set the flag as true
			else
				flag = true;

			/* Check if right child is present */
			if (temp_node.right != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty right child, then the given tree is not
				// a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Right Child
				queue.add(temp_node.right);

			}
			// If this a non-full node, set the flag as true
			else
				flag = true;
		}
		// If we reach here, then the tree is complete Binary Tree
		return true;
	}

}
