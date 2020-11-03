/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 144 : 
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class IterativeBinaryTreePreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Stack 
	// Push right first before left.
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null) return result;
		Stack<TreeNode> st = new Stack<TreeNode>();
		
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode temp = st.pop();
			result.add(temp.val);
			
			// push right first 
			if(temp.right != null) {
				st.push(temp.right);
			}
			
			// push left afterwards
			if(temp.left != null) {
				st.push(temp.left);
			}
		}
		return result;
		
	}

}
