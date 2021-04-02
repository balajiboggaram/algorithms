/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayDeque;
import java.util.Deque;

import me.learn.utli.TreeNode;

/**
 * Title 449 :
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class SearializeDeserializeBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SearializeDeserializeBST solution = new SearializeDeserializeBST();

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);

		t2.left = t1;
		t2.right = t3;

		Codec1 solution1 = new Codec1();
		solution1.serialize(t2);

	}

}

class Codec1 {

	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		postOrder(root, sb);
		if (sb.length() > 0) {
			// Lets remove the last character here space
			sb.deleteCharAt(sb.length() - 1);
		}

		System.out.println(sb.toString());
		return sb.toString();

	}

	private void postOrder(TreeNode root, StringBuilder sb) {

		if (root == null)
			return;
		postOrder(root.left, sb);
		postOrder(root.right, sb);
		sb.append(root.val);
		sb.append(" ");

	}
	
  

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] s = data.split("\\s+");
		Deque<Integer> q = new ArrayDeque<Integer>();
		for (String a : s) {
			q.add(Integer.parseInt(a));
		}
		return util(Integer.MIN_VALUE, Integer.MAX_VALUE, q);

	}
	
	

	private TreeNode util(Integer minValue, Integer maxValue, Deque<Integer> q) {

		if (q.isEmpty())
			return null;

		int val = q.getLast();
		if (val < minValue || val > maxValue) {
			return null;
		}

		q.removeLast();
		TreeNode root = new TreeNode(val);
		root.right = util(val, maxValue, q); // Here right should come before left due to reverse unfold of post order.
		root.left = util(minValue, val, q);
		return root;

	}
	
}
