/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 687 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class LongestUniValuePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root == null)
			return 0;

		util(root);
		return result;
	}

	private int util(TreeNode root) {
		
		if(root == null) return 0;
		
		int maxLeft = util(root.left);
		int maxRight = util(root.right);
		
		
		int rootLeft = 0, rootRight =0;
		if(root.left != null && root.val == root.left.val) {
			rootLeft = maxLeft + 1;
		}
		
		if(root.right != null && root.val == root.right.val) {
			rootRight = maxRight + 1;
		}
		
		result = Math.max(result, rootLeft + rootRight );
		
		return Math.max(maxLeft, maxRight);
		
		
	}

}
