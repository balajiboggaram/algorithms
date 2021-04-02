/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 1379 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindRefNodeInClonedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// you can solve this either using DFS or BFS>
	// BFS - just store the count of nodes until target, and then just return.
	// DFS - firest find the node, track their movement with characters L and R.
	// Now, traverse again on clone with help of directions string

	TreeNode result;

	// I am just using BFS here
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

		int count = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(original);
		while (!q.isEmpty()) {
			count++;
			TreeNode temp = q.poll();
			if (temp.val == target.val)
				break;
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}

		// once we have the count, lets traverse in the clone for count times using BFS
		Queue<TreeNode> qClone = new LinkedList<TreeNode>();
		qClone.add(cloned);
		while (!qClone.isEmpty() && count > 0) {
			TreeNode temp = qClone.poll();

			count--;
			if (count == 0)
				return temp;
			if (temp.left != null)
				qClone.offer(temp.left);
			if (temp.right != null)
				qClone.offer(temp.right);
		}
		return result;

	}
}
