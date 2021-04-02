/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 450 : 
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class DeleteNodeInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Delete a node in BST
	// 3 cases exist for the node to be deleted ? 
	// node has no children
	// node has only child, either left or right 
	// node has both children
	
    public TreeNode deleteNode(TreeNode root, int key) {
    
    	if(root == null) return root;
    	if(key < root.val) {
    		root.left = deleteNode(root.left, key);
    		return root;
    	} else if(key > root.val) {
    		root.right = deleteNode(root.right, key);
    		return root;
    	} else {
    		// node to be deleted is found. Now lets see 3 cases
    		
    		if(root.left == null) return root.right;
    		else if(root.right == null) return root.left;
    		else {
    			TreeNode successor = minValue(root.right); // sub case 1. Fetch the inorder successor which is minimum node
    			root.val = successor.val;
    			root.right = deleteNode(root.right, root.val); // now delete the min node by calling it again recursively
    		}
    		
    	}
    	return root;
    	
    }

	private TreeNode minValue(TreeNode cur) {
		if (cur == null)
			return null;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

}
