/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 103 :
 * 
 *  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class BinaryTreeZigZagLevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// TWO STACKs
	// keep a boolean : right 
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null) return result;
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		boolean right = true;

		List<Integer> level = new ArrayList<Integer>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode temp = s1.pop();
			level.add(temp.val);

			// right = true, -> left, right
			// right = false, ->  right, left
			if(right) {
				addNode(s2, temp.left);
				addNode(s2, temp.right);
			} else {
				addNode(s2, temp.right);
				addNode(s2, temp.left);
			}
			
			// reset the few stuff as we are done with level.
			if(s1.isEmpty()) {
				result.add(level);
				right = !right;
				s1 = s2;
				s2 = new Stack<TreeNode>();
				level = new ArrayList<Integer>();
			}

		}
		
		// any elements in the stack last level; 
		
		return result;

	}
	
	private void addNode(Stack<TreeNode> s, TreeNode t) {
		if(t != null) 
			s.push(t);
	}

}
