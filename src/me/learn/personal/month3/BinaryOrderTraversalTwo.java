/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 107 :
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 * 
 * @author bramanarayan
 * @date Jul 2, 2020
 */
public class BinaryOrderTraversalTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null) return result;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		Stack<List<Integer>> st = new Stack<List<Integer>>();
		int curLevel = 1, nextLevel = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		while(!q.isEmpty()) {
			TreeNode t = q.remove();
			curLevel--;
			
			list.add(t.val);
			
			// add left node
			if(t.left != null) {
				q.add(t.left);
				nextLevel++;
			}
			
			// add right node
			if(t.right != null) {
				q.add(t.right);
				nextLevel++;
			}
			
			if(curLevel == 0) {
				st.add(list);
				list = new ArrayList<Integer>();
				curLevel = nextLevel;
				nextLevel =0;
			}
			
		}
		
		// iterate the stack
		while(!st.isEmpty()) {
			result.add(st.pop());
		}
		
		return result;
	}

}
