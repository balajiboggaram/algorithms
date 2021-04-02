/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 104  
 * 
 * Date : Dec 10, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaxDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode temp = new TreeNode(100);
		MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();
		System.out.println(solution.maxDepth(temp));

	}
	
	public int maxDepth(TreeNode root) {
	    if (root == null) {
	      return 0;
	    } else {
	      int left_height = maxDepth(root.left);
	      int right_height = maxDepth(root.right);
	      return java.lang.Math.max(left_height, right_height) + 1;
	    }
	  }

}
