/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 404 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class SumOfLeftLeavesBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// You need to sum only the left leaves.

	// A pure BFS
	public int sumOfLeftLeaves(TreeNode root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				
				// the catch here is that you need to consider ONLY LEFT ELEMENTS
				if (temp.left != null) {
					q.add(temp.left);
					if (temp.left.left == null && temp.left.right == null) {
						result += temp.left.val;
					}
				}

				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return result;

	}

}
