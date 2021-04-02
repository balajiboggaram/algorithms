/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1522 :
 * 
 * Date : Dec 28, 2020
 * 
 * @author bramanarayan
 *
 */
public class DiameterOfNAryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Diameter of N Ary tree
	// At any given instant, find the two nodes with max height
	int result = 0;

	public int diameter(Node root) {
		height(root);
		return result;

	}

	private int height(Node node) {
		if (node == null)
			return 0;
		if (node.children.size() == 0)
			return 0;

		int max1 = 0, max2 = 0;
		for (Node child : node.children) {
			int curHeight = height(child) + 1;
			if (curHeight > max1) {
				max2 = max1;
				max1 = curHeight;
			} else if (curHeight > max2) {
				max2 = curHeight;
			}
			result = Math.max(result, max2 + max1);
		}
		return Math.max(max1, max2);
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
