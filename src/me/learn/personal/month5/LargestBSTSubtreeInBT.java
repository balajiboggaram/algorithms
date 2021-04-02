/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 333 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class LargestBSTSubtreeInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// largest means the number of nodes in the subtree.
	// a subtree must include all of its descnendants

	// Maintain max and min to check if tree violates BST property.
	// Other than that, check the leftSize and rightSize and keep updating the
	// result

	int result = 0;

	public int largestBSTSubtree(TreeNode root) {
		if (root == null)
			return result;

		util(root);
		return result;
	}

	private Result util(TreeNode root) {
		
		if(root == null) {
			return new Result(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		Result left = util(root.left);
		Result right = util(root.right);
		
		// test for -ve scenario (violating BST?)
		if(left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min) {
			return new Result(-1, 0,0);
		}
		
		int size = left.size + right.size + 1;
		
		result = Math.max(result, size); // update tracker
		
		return new Result(size, Math.max(root.val, right.max), Math.min(root.val, left.min));
	}

	class Result {
		int size;

		public Result(int size, int max, int min) {
			this.size = size;
			this.max = max;
			this.min = min;
		}

		int max;
		int min;
	}

}
