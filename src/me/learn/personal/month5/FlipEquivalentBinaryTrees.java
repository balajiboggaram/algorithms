/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 951 :
 * 
 * Date : Dec 27, 2020
 * 
 * @author bramanarayan
 *
 */
public class FlipEquivalentBinaryTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null)
			return true;
		
		
		if(root1 == null || root2 == null || root1.val != root2.val) return false;
		
		
		// now we have got 2 combiantions to try
		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))  || // --> you dont flip the tree
				(flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)); // ---> you flip the tree

	}

}
