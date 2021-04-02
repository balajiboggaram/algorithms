/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1490 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class CloneNAryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneTree(Node root) {
		if (root == null)
			return null;
		
		Node newRoot = new Node(root.val);
		for(Node child : root.children) {
			newRoot.children.add(cloneTree(child));
		}
		
		return newRoot;
				
		
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
