/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 98 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class ValidateBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			System.out.println(Integer.MAX_VALUE);
	}

	
	// Handle integer overflow (you can covert to wrapper data types)
	public boolean isValidBST(TreeNode root) {
		
		return util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean util(TreeNode root, int minValue, int maxValue) {
		if (root == null)
			return true;

		if (root.val <= minValue || root.val >= maxValue)
			return false;

		return util(root.left, minValue, root.val) && util(root.right, root.val, maxValue);
	}

}
