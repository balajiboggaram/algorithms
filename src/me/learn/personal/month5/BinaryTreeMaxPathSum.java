/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 124 :
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class BinaryTreeMaxPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result  = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxGain(root);
	    return result;
	  }
	
	int maxGain(TreeNode root) {
		if (root == null)
			return 0;

		int leftMax = Math.max(0, maxGain(root.left));
		int rightMax = Math.max(0, maxGain(root.right));

		// now compare here
		int withRoot = leftMax + rightMax + root.val;

		result = Math.max(result, withRoot);
		return root.val + Math.max(leftMax, rightMax);

	}

}
