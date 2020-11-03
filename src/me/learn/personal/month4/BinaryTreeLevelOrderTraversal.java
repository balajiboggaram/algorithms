/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 102 :
 * 
 *  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// Queue
	// First left and then right. FIFO
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int cur = 1;;
		int next = 0;
		if(root == null)
			return result;
		
		List<Integer> level = new LinkedList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			
			TreeNode temp= q.remove();
			
			level.add(temp.val);
			cur--;

			if(temp.left!= null) {
				q.add(temp.left);
				next++;
			}
			if(temp.right!= null) {
				q.add(temp.right);
				next++;
			}
			
			
			// level is completed
			if(cur == 0) {
				result.add(level);
				level = new ArrayList<Integer>();
				cur = next;
				next = 0;
			}
			
		}
		
		if(level.size() > 0) {
			result.add(level);
		}
		return result;
		
	}

}
