/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayDeque;
import java.util.Deque;

import me.learn.utli.TreeNode;

/**
 * Title 662 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaximumWidthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Maximum width among all the levels
	// purely based on node position + BFS
	public int widthOfBinaryTree(TreeNode root) {

		if (root == null)
			return 0;

		Deque<Pair> q = new ArrayDeque<Pair>();
		q.add(new Pair(root, 0));
		int maxWidth = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			int firstIndex = q.getFirst().index;
			int lastIndex = q.getLast().index;
			maxWidth = Math.max(maxWidth, Math.abs(firstIndex - lastIndex) + 1);

			for (int i = 0; i < size; i++) {
				Pair temp = q.poll();
				if (temp.node.left != null) {
					q.offer(new Pair(temp.node.left, 2 * temp.index + 1));
				}

				if (temp.node.right != null) {
					q.offer(new Pair(temp.node.right, 2 * temp.index + 2));
				}
			}
		}
		
		return maxWidth;

	}

	class Pair {
		public Pair(TreeNode node, int hd) {
			this.node = node;
			this.index = hd;
		}

		TreeNode node;
		int index;
	}
}
