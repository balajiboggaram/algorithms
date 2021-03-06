package me.learn.personal.month1;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

public class CousinsTree {

	public static void main(String args[]) {

		CousinsTree solution = new CousinsTree();

	}

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int curLevel = 1, nextLevel = 0;
		q.add(root);

		TreeNode xParent = null, yParent = null;

		while (!q.isEmpty()) {
			TreeNode t = q.remove();
			if (t.left != null) {
				q.add(t.left);
				nextLevel++;

				// Capture the parent on any match of left node
				if (t.left.val == x)
					xParent = t;
				if (t.left.val == y)
					yParent = t;

			}
			if (t.right != null) {
				q.add(t.right);
				nextLevel++;

				// Capture the parent on any match of right node
				if (t.right.val == x)
					xParent = t;
				if (t.right.val == y)
					yParent = t;
			}
			curLevel--;
			if (curLevel == 0) {
				curLevel = nextLevel;
				nextLevel = 0;
				if (contains(q, x, y) && xParent != yParent)
					return true;
			}
		}
		return false;
	}

	/**
	 * basically this acts as depth tracker
	 */
	private boolean contains(Queue<TreeNode> q, int x, int y) {
		System.out.println(q.toArray());
		boolean xFound = false, yFound = false;
		for (TreeNode node : q) {
			if (!xFound && node.val == x) {
				xFound = true;
			}
			if (!yFound && node.val == y) {
				yFound = true;
			}

		}
		return xFound && yFound;
	}

	// or
	// based on DFS

	class Solution {
		TreeNode xParent = null;
		TreeNode yParent = null;
		int xDepth = -1, yDepth = -1;

		public boolean isCousins(TreeNode root, int x, int y) {
			getDepthAndParent(root, x, y, 0, null);
			return xDepth == yDepth && xParent != yParent ? true : false;
		}

		// get both the depth and parent for x and y
		public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent) {
			if (root == null) {
				return;
			}
			if (root.val == x) {
				xParent = parent;
				xDepth = depth;
			} else if (root.val == y) {
				yParent = parent;
				yDepth = depth;
			}
			getDepthAndParent(root.left, x, y, depth + 1, root);
			getDepthAndParent(root.right, x, y, depth + 1, root);
		}
	}

}
