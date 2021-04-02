
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 700 : 
 * 
 * Date : Dec 13, 2020
 * 
 * @author bramanarayan
 *
 */
public class SearchInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode searchBST(TreeNode root, int val) {
     
    	if(root == null) return null;
    	if(root.val == val) return root;
    	if(root.val < val) return searchBST(root.right, val) ; else 
    		return searchBST(root.left, val);
    	
    }
	
}
