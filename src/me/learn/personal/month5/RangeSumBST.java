/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 938 : Given the root node of a binary search tree, return the sum of
 * values of all nodes with a value in the range [low, high].
 * 
 * Date : Dec 11, 2020
 * 
 * @author bramanarayan
 *
 */
public class RangeSumBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sum = 0;
	public int rangeSumBST(TreeNode root, int low, int high) {
		
		if(root == null) return 0;
		sumUtil(root, low, high);
		return sum;
	}
	
	void sumUtil(TreeNode root, int low, int high) {
		if(root == null) return;
		if(root.val >= low && root.val <= high) {
			sum += root.val;
			sumUtil(root.left, low, high);
			sumUtil(root.right, low, high);
		} else if(root.val > high) {
			sumUtil(root.left, low, high);
		} else {
			sumUtil(root.right, low, high);
		}
	}
}
