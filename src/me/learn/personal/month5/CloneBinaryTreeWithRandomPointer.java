package me.learn.personal.month5;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title 1485 :
 * 
 * Date : Dec 24, 2020
 * 
 * @author bramanarayan
 *
 */
public class CloneBinaryTreeWithRandomPointer {

	/**
	 * Basically, you need to maintain a map of old node -> new node.
	 * then traverse again - like preorder to populate random pointers
	 */
	public NodeCopy copyRandomBinaryTree(Node root) {

		if (root == null)
			return null;
		Map<Node, NodeCopy> map = new HashMap<>();
		NodeCopy copyRoot = constructTree(root, map);
		populateRandom(root, copyRoot, map);
		return copyRoot;

	}

	private void populateRandom(Node root, NodeCopy copyRoot, Map<Node, NodeCopy> map) {
		if (root == null)
			return;
		if (root.random != null) {
			copyRoot.random = map.get(root.random);
		}
		populateRandom(root.left, copyRoot.left, map);
		populateRandom(root.right, copyRoot.right, map);
	}

	private NodeCopy constructTree(Node root, Map<Node, NodeCopy> map) {

		if (root == null)
			return null;
		NodeCopy temp = new NodeCopy(root.val);
		map.put(root, temp);
		temp.left = constructTree(root.left, map);
		temp.right = constructTree(root.right, map);
		return temp;

	}
}

class NodeCopy {
	NodeCopy left;
	int val;
	NodeCopy right;
	NodeCopy random;

	public NodeCopy(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

class Node {
	int val;
	Node left;
	Node right;
	Node random;

	Node() {
	}

	Node(int val) {
		this.val = val;
	}

	Node(int val, Node left, Node right, Node random) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.random = random;
	}
}