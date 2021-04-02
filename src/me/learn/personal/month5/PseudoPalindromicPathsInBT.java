/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

import me.learn.utli.TreeNode;

/**
 * Title 1457 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class PseudoPalindromicPathsInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;

	public int pseudoPalindromicPaths(TreeNode root) {
		if (root == null)
			return 0;
		util(root, new int[9]);
		return result;
	}

	// we cannot have more than 1 - odd number of counts at leaf node
	private void util(TreeNode root, int[] count) {
		if (root == null)
			return;

		count[root.val-1]++;
		
		if(root.left == null && root.right == null && isPseudoCheck(count)) {
            System.out.println("Ans:" + Arrays.toString(count));
			result++;
		}
		util(root.left, count);
		util(root.right, count);

		count[root.val - 1]--; // backtrack here

	}

	private boolean isPseudoCheck(int[] count) {
		int oddCount = 0;
		for (int i = 0; i < 9; i++) {
			if (count[i] % 2 == 1)
				oddCount++;
			if (oddCount > 1)
				return false;
		}
		return true;
	}

}
