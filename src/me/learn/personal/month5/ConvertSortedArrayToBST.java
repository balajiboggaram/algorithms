/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 108 : 
 * 
 *  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class ConvertSortedArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] a;

	private TreeNode util(int l, int h) {
		if (l > h)
			return null;
		int m = (l + h) / 2;
		// always choose the right middle node as root.
		if ((l + h) % 2 == 1)
			++m; // increment m on odd # of nodes

		TreeNode root = new TreeNode(a[m]);
		root.left = util(l, m - 1);
		root.right = util(m + 1, h);
		return root;

	}

	public TreeNode sortedArrayToBST(int[] a) {
		this.a = a;
		int n = a.length;
		return util(0, a.length - 1);

	}

}
