/**
 * 
 */
package me.learn.personal.month4;

import me.learn.utli.TreeNode;

/**
 * Title 270 :
 * 
 *  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4


 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class ClosestBinarySearchTree {

	int result ;
	double minDiff = Integer.MAX_VALUE;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClosestBinarySearchTree solution = new ClosestBinarySearchTree();
	/*	TreeNode four = new TreeNode(4);
		four.left  = new TreeNode(2);
		four.right = new TreeNode(5);
		four.left.left = new TreeNode(1);
		four.left.right = new TreeNode(3);
		System.out.println(solution.closestValue(four, 3.714286));*/
		
		TreeNode one = new TreeNode(1500000000);
		one.left = new TreeNode(1400000000);
		System.out.println(solution.closestValue(one, -1500000000));
		
	}

	
	// handles overflow
	public int closestValue(TreeNode root, double target) {
	    int val, closest = root.val;
	    while (root != null) {
	      val = root.val;
	      closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
	      root =  target < root.val ? root.left : root.right;
	    }
	    return closest;
	  }
	
	// Does not handle integer overflow
	public int closestValueMy(TreeNode root, double target) {
		
		int result = -1;
		double curDiff = Integer.MAX_VALUE;
		double minDiff = Integer.MAX_VALUE;

		if(root == null) return -1;
		if(root.left == null && root.right == null) return root.val;
		
		while(root != null) {
			 curDiff = Math.abs(root.val - target);
			
			if(curDiff < minDiff) {
				minDiff = curDiff;
				result = root.val;
			} 
			if( target < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		
		}		
		return result;
				
	}

}
