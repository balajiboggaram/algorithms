package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * 
 * Title 199 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class RightSideViewOfBT {

	// basically last node of every level.
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			Integer prev = null;
			int size = q.size();
			for(int i = 0; i<size;i++) {
				TreeNode temp = q.poll();
					prev = temp.val;
					if(temp.left != null) q.offer(temp.left);
					if(temp.right != null) q.offer(temp.right);
				
			}
			
			result.add(prev);
		}
		return result;
	}
}
