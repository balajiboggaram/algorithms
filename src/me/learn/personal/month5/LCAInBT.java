/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 236 : 
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class LCAInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Both the nodes p and q exist in tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	if(root == null) return null;
    	
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if(root.val == p.val || root.val == q.val)
    		return root;
    	
    	if(left != null && right != null) return root;
    	
    	return left == null ? right : left;
    }

}
