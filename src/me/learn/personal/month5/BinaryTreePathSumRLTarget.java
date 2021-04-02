/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 112 :
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class BinaryTreePathSumRLTarget {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSum(TreeNode root, int target) {
		
		return PathSumUtil(root, 0, target);
	}

	private boolean PathSumUtil(TreeNode root, int curSum, int target) {

		if(root == null ) return false;
		curSum = curSum + root.val;
		if(curSum == target && root.left == null && root.right == null) {
			return true;
		}
		
		return PathSumUtil(root.left, curSum, target) || PathSumUtil(root.right, curSum, target);
		
		
		
	}
	
	

}
