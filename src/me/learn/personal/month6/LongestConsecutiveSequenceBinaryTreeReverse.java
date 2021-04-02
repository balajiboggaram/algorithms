/**
 * 
 */
package me.learn.personal.month6;

import me.learn.utli.TreeNode;

/**
 * Title 549 : 
 * 
 * Date : Jan 30, 2021
 * 
 * @author bramanarayan
 *
 */
public class LongestConsecutiveSequenceBinaryTreeReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Integer result = 0;
	Integer length = 1;
    Integer minusLength = 1;

	public int longestConsecutive(TreeNode root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		util(root, 0, root.val);
        
        utilMinus(root, 0, root.val);

		return Math.max(length, minusLength);
	}

	private void util(TreeNode root, Integer current, Integer target) {

		if (root == null)
			return;

		if (root.val == target)
			current++;
		else
			current = 1;

		length = Math.max(length, current);

		util(root.left, current, root.val + 1);
		util(root.right, current, root.val + 1);

	}
    
    
	private void utilMinus(TreeNode root, Integer current, Integer target) {

		if (root == null)
			return;

		if (root.val == target)
			current++;
		else
			current = 1;

		minusLength = Math.max(minusLength, current);

		util(root.left, current, root.val - 1);
		util(root.right, current, root.val - 1);

	}

}
