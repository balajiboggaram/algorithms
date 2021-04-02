/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 1302 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class DeepestLeavesSumBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Find the sum of deepest leaf nodes
	// Do a simple BFS, return the sum of last level
	public int deepestLeavesSum(TreeNode root) {

		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int levelSum = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			levelSum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				levelSum += temp.val;
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}

		}
		return levelSum;
	}

}
