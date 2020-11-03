package me.learn.utli;

/**
 * 
 * Title : A simple Binary  Tree node 
 * 
 * @author bramanarayan
 * @date May 2, 2020
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
