/**
 * 
 */
package me.learn.personal.month5;

import java.util.Stack;

import me.learn.utli.Node;

/**
 * Title 426 : 
 * 
 * Date : Dec 9, 2020
 * 
 * @author bramanarayan
 *
 */
public class ConvertBSTToCircularDoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// node -> TreeNode here.
	public Node treeToDoublyList(Node root) {
		if (root == null)
			return null;
		Stack<Node> stack = new Stack<>();
		Node pre = null, head = null, cur = root;
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			// first element
			if (pre == null) {
				head = cur;
			} else {
				pre.right = cur;
				cur.left = pre;
			}
			pre = cur;
			cur = cur.right;
		}

		head.left = pre;
		pre.right = head;
		return head;
	}

}
