/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 1161 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaxLevelTreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// return level as max answer
	public int maxLevelSum(TreeNode root) {

		if (root == null)
			return 0;
		int maxSum = 0;
		int level = 0;
		int maxLevel = level;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {

				TreeNode temp = q.remove();
				sum += temp.val;
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			level++;
			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = level;
			}

		}
		return maxLevel;
	}

	// return max sum as answer

	public int maxLevelSum1(TreeNode root) {

		if (root == null)
			return 0;
		int result = 0;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {

				TreeNode temp = q.remove();
				sum += temp.val;
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
			result = Math.max(result, sum);

		}
		return result;
	}

}
