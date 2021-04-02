/**
* 
*/
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * Title 1602 :
 * 
 * Date : Dec 25, 2020
 * 
 * @author bramanarayan
 *
 */
public class NearestRightNodeBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {

		if (u == null || root == null)
			return null;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				if(temp == u && i != size-1) {
					return q.peek();
					
				}
				if(temp.left != null) q.offer(temp.left);
				if(temp.right != null) q.offer(temp.right);
				
			}
		}
		
		return null;
			
	}

}
