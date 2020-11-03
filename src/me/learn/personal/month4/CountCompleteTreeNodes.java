/**
 * 
 */
package me.learn.personal.month4;

import me.learn.utli.TreeNode;

/**
 * Title 222 :
 * 
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note:
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * Example:
 * 
 * Input: 1 / \ 2 3 / \ / 4 5 6
 * 
 * Output: 6
 * 
 * @author bramanarayan
 * @date Aug 3, 2020
 */
public class CountCompleteTreeNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
		TreeNode one = new TreeNode(1);
		one.left  = new TreeNode(2);
		one.right = new TreeNode(3);
		one.right.left = new TreeNode(6);
		one.right.right = new TreeNode(10);
		one.left.left = new TreeNode(4);
		one.left.right = new TreeNode(5);
		System.out.println(solution.countNodes(one));
	}

	// MY GOOGLE QUESTION :-( I failed in the interview :-)
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		// find the depth of tree
		int d = 0;
		TreeNode cur = root;
		while (cur.left != null) {
			cur = cur.left;
			d++;
		}

		if(d == 0) return root.val;
		
		// Last level only processing
		// Find the last index using Binary search in a Binary Search
		int l = 1; // low start from 0th node
		int h = (int) Math.pow(2, d) - 1; // high, end at 2^d -1 node number
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (indexExists(root, mid, d)) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		int count1 = (int) Math.pow(2, d) -1; // nodes leaving level d
		count1 = count1 + l; // add nodes in the last level. l would point to it.
		return count1;

	}

	// This is little tricky, work with an example.
	// you will able to make a decision how to traverse from root -> to left or
	// right based on mid comparision with root value
	public boolean indexExists(TreeNode root, int index, int depth) {

		int l = 0;
		int h = (int) Math.pow(2, depth) - 1;
	
		// traverse the depth -->> IMPORTANT
		for(int i = 0; i < depth;i++) {
			int mid = l + (h - l) / 2;
			if (index <= mid) {
				root = root.left;
				h = mid;
			} else {
				root = root.right;
				l = mid + 1;
			}
		}
		
		return root != null; // If the root is not null, then you would have landed at the indexTH node in
								// binarytree.

	}

}
