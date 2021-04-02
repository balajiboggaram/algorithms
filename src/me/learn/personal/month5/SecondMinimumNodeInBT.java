/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 671 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class SecondMinimumNodeInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int min1;
	long min2 = Long.MAX_VALUE;

	public void dfs(TreeNode root) {
		if (root != null) {

			// Always try to update the min2, root value should be greater than min1 and less than min2
			if (min1 < root.val && root.val < min2) {
				min2 = root.val;
			} else if (min1 == root.val) {
				// else all other cases do not interest me
				dfs(root.left);
				dfs(root.right);
			}
		}
	}

	public int findSecondMinimumValue(TreeNode root) {
		min1 = root.val;
		dfs(root);
		return min2 < Long.MAX_VALUE ? (int) min2 : -1;
	}

}
