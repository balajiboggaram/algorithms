/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 701 :
 * 
 * Date : Dec 13, 2020
 * 
 * @author bramanarayan
 *
 */
public class InsertIntoBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		 if (root == null) return new TreeNode(val);

		    // insert into the right subtree
		    if (val > root.val) {
		    	root.right = insertIntoBST(root.right, val);
		    }  // insert into the left subtree
		    else  {
		    	root.left = insertIntoBST(root.left, val);
		    }
		    return root;
		
	}

	// WRONG
	public void insertBST(TreeNode root, int key) {

		if(root.left == null && root.right == null) {
			if(key < root.val) {
				root.left = new TreeNode(key);
			} else {
				root.right = new TreeNode(key);
			}
			return;
		}
		
		if (root.left != null && root.val > key)
			insertIntoBST(root.left, key);
		else if(root.right != null && root.val < key)
			insertIntoBST(root.right, key);

	}

}
