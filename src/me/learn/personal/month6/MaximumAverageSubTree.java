/**
 * 
 */
package me.learn.personal.month6;

import me.learn.utli.TreeNode;

/**
 * Title 1120 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaximumAverageSubTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * double result = 0;
	 * 
	 * public double maximumAverageSubtree(TreeNode root) {
	 * 
	 * if (root == null) return 0;
	 * 
	 * util(root); return result;
	 * 
	 * }
	 * 
	 * int count = 0; private Double util(TreeNode root) {
	 * 
	 * if (root == null) return (double) 0;
	 * 
	 * Double lSum = util(root.left); Double rSum = util(root.right); count++;
	 * result = Math.max(result, (lSum + rSum + root.val)/count);
	 * 
	 * 
	 * return lSum + rSum + root.val;
	 * 
	 * }
	 */

	// or
	
	double res;

	public double maximumAverageSubtree(TreeNode root) {
		res = 0;
		sumAndNum(root);
		return res;
	}

	// {num,sum}
	public int[] sumAndNum(TreeNode node) {
		if (node == null)
			return new int[] { 0, 0 };
		int sum = node.val;
		int num = 1;

		int[] left = sumAndNum(node.left);
		int[] right = sumAndNum(node.right);

		num += left[0] + right[0];
		sum += left[1] + right[1];

		res = Math.max(res, (double) sum / (double) num);

		return new int[] { num, sum };
	}

}
