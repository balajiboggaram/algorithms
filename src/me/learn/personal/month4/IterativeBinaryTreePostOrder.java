/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 145 :
 * 
 *  Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?

 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class IterativeBinaryTreePostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// TWO stacks - s2 is the answer
	// as soon as you pop from s1 , just add to s2.
	// insert left and then right, as we pop the elements from s2 for final answer.
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();

		if(root == null) return result;
		s1.push(root);
		while(!s1.isEmpty()) {
			
			TreeNode temp= s1.pop();
			s2.push(temp); // immidiately push to s2 stack
			
			if(temp.left != null) {
				s1.push(temp.left);
			}
			
			if(temp.right != null) {
				s1.push(temp.right);
			}
		}
		
		while(!s2.isEmpty()) {
			result.add(s2.pop().val);
		}
		return result;
	}

}
