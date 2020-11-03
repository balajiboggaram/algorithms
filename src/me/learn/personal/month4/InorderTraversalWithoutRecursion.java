/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 94 :
 * 
 * traverse a binary tree inorder without any sort of recursion.
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class InorderTraversalWithoutRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// Push the elements of root and its left to stack.
	// after elements of left to left are pushed, the top element of stack is the min
	// now once that is done, we need to traverse to right of the popped element.
	// ALL are played with cur pointer !!! 
	public List<Integer> inorderTraversal(TreeNode root) {
		
		List<Integer> result = new ArrayList<Integer>();
		TreeNode cur = root;
		Stack<TreeNode> st = new Stack<TreeNode>(); 
		
		// OR symbol
		while(cur != null || !st.isEmpty()) {
			
			while( cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			result.add(st.peek().val);
			
			cur = st.pop();
			cur = cur.right;
			
		}
		return result;
		
	}

}
