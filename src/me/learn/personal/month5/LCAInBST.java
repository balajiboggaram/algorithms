/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 235 : 
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class LCAInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// This is in a binary search tree
	// Both the nodes p and q exist in tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        	
    	if(root == null) return null;
    	
    	if(p.val < root.val && q.val< root.val) {
    		return lowestCommonAncestor(root.left, p, q);
    	}

    	if(p.val > root.val && q.val > root.val) {
    		return lowestCommonAncestor(root.right, p, q);
    	}
    	
    	return root;

    }

}
