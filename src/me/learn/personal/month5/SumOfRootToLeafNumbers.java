/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 129 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class SumOfRootToLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int result = 0;
	
	// Read all the digits from root to leaf and sum it up
	public int sumNumbers(TreeNode root) {

		if(root == null) return 0;
		
		util(root, 0);
		return result;
	}

	private void util(TreeNode root, int sum) {
		if(root == null) return;
		
		sum = sum * 10 + root.val; // addition from top to bottom. i,e root to leaf
		
		if(root.left == null && root.right == null) {
			result += sum;
		}
		
		util(root.left, sum);
		util(root.right, sum);
		
	}

}
