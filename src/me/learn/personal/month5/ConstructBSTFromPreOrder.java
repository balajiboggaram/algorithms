/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 1008 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class ConstructBSTFromPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode bstFromPreorder(int[] preorder) {
		n = preorder.length;
		return util(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	int preIndex = 0;
	int n;

	
	// Keep preIndex, now - call recursively with  min and max value.
	private TreeNode util(int[] a, int minValue, int maxValue) {
		if (preIndex == n)
			return null; // tree is already constructed.

		int key = a[preIndex];
		if (key < minValue || key > maxValue)
			return null; // current element cannot be placed here to meet BST requirements.

		preIndex++;

		TreeNode root = new TreeNode(key);
		root.left = util(a, minValue, key);
		root.right = util(a, key, maxValue);
		return root;
	}

}
