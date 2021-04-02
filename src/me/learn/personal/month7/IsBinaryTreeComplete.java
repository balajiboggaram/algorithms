/**
 * 
 */
package me.learn.personal.month7;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 958 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class IsBinaryTreeComplete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// When level-order traversal in a complete tree, after the last node, all nodes
	// in the queue should be null.
	// Otherwise, the tree is not complete.

	public boolean isCompleteTree(TreeNode root) {
		boolean end = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null)
				end = true;
			else {
				if (end)
					return false;
				queue.add(cur.left);
				queue.add(cur.right);
			}
		}
		return true;
	}

}
