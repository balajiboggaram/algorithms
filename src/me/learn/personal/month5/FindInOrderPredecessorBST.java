/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title : 
 * 
 * Date : Dec 27, 2020
 * 
 * @author bramanarayan
 *
 */
public class FindInOrderPredecessorBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// The predecessor in BST is basically the left most node possible
	
	// not in LC
	TreeNode predecessor(TreeNode root) {
		TreeNode cur = root;
		cur = cur.left;
		while(cur != null) {
			cur = cur.left;
		}
		return cur;
	}

}
