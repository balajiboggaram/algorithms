/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 617 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class MergeTwoBinaryTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// The definition of merge here is to add the values
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		if(t1 == null && t2 == null) return null;
		
		int val1 = t1 == null ? 0 : t1.val;
		int val2 = t2 == null ? 0: t2.val;
		
		TreeNode root = new TreeNode(val1 + val2);
		root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
		root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
		
		return root;
		
	}

}
