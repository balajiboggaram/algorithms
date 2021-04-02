/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 111 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinimumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Minimum depth is the number of nodes along the shortest path from the root
	// node down to the nearest leaf node
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;

			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if (temp.left == null && temp.right == null)
					return level;

				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}

		}
		return -1;
	}

}
