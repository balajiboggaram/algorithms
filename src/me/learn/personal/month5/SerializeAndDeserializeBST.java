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
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class SerializeAndDeserializeBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {

			if (root == null)
				return "";

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

			if (s.length == 0)
				return null;
			Deque<Integer> list = new ArrayDeque<Integer>();

			for (String a : s) {
				list.add(Integer.parseInt(a));
			}
			return util(Integer.MIN_VALUE, Integer.MAX_VALUE, list);

		}

		private TreeNode util(Integer minValue, Integer maxValue, Deque<Integer> list) {

			if (list.isEmpty())
				return null;

			int val = list.getLast();
			if (val < minValue || val > maxValue) {
				return null;
			}

			list.removeLast(); // this will be the root node
			TreeNode root = new TreeNode(val);

			root.right = util(val, maxValue, list); // frame the right tree keeping root as min.
			root.left = util(minValue, val, list); // frame the left tree keeping root as max. this is exactly reverse
													// of post order. L R Root --> Root, R, L

			return root;

		}

	}

}
