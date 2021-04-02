/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 606 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class ConstructStringFromBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// you need a string that separates nodes in a level with paranthesis
	public String tree2str(TreeNode root) {

		if (root == null)
			return "";

		StringBuilder sb = new StringBuilder();
		util(root, sb);
		return sb.toString();

	}

	private void util(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}

		sb.append(root.val);
		if (root.left != null) {
			sb.append("(");
			util(root.left, sb);
			sb.append(")");
		}

		if (root.right != null) {
			
			
			// This is required cos, Lets say input is : [1,2,3,null,4]
			// expected output is : "1(2()(4))(3)". i.e FOr null left node, you need to append a empty ()
			if(root.left == null) {
				sb.append("()");
			}
			sb.append("(");
			util(root.right, sb);
			sb.append(")");
		}
	}

}
