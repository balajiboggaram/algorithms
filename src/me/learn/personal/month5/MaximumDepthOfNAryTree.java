/**
 * 
 */
package me.learn.personal.month5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title 559 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaximumDepthOfNAryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is an N ary tree. Each node can have more than 2 children 
	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				for (int j = 0; j < temp.children.size(); j++) {
					q.offer(temp.children.get(j));
				}
			}
		}
		return level;

	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

}
