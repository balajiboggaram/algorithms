/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Title 428 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class SerializeAndDeserializeNAryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Codec {

		// Encodes a tree to a single string.
		public String serialize(Node root) {

			if (root == null)
				return "";

			StringBuilder sb = new StringBuilder();
			serialUtil(root, sb);
			return sb.toString();

		}

		private void serialUtil(Node root, StringBuilder sb) {
			if (root == null)
				return;
			sb.append(root.val + " "); 

			if (root.children.size() > 0) {
				sb.append(" [");
				for (Node child : root.children) {
					serialUtil(child, sb);
				}
				sb.append("] ");
			}
		}

		// Decodes your encoded data to tree.
		public Node deserialize(String data) {
			if (data == null || data.length() < 1)
				return null;

			String[] nodes = data.split("\\s+");

			Stack<Node> st = new Stack<Node>();

			Node cur = new Node(Integer.parseInt(nodes[0]), new ArrayList<Node>());

			st.push(cur);
			Node parent = null;
			for (int i = 1; i < nodes.length; i++) {
				if (nodes[i].equals("[")) {
					st.push(cur);
				} else if (nodes[i].equals("]")) {
					parent = st.pop();
				} else {
					
					// handle if there multiple digits in root node value
					cur = new Node(Integer.parseInt(nodes[i]), new ArrayList<Node>());
					st.peek().children.add(cur);
				}
			}
			return parent;
		}
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
	};

}
