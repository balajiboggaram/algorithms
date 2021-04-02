/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 988 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class LexicographicSmallestStringRootToLeaf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// String builder reverses the whole string as soon as you invoke reverse. if
		// you want original, you need to call it again.
		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		System.out.println(sb.reverse().toString());
		System.out.println(sb.toString());
		sb.reverse();
		System.out.println(sb.toString());
	}

	String result;

	public String smallestFromLeaf(TreeNode root) {

		if (root == null)
			return result;

		util(root, new StringBuilder());
		return result;
	}

	void util(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;

		sb.append((char) ('a' + root.val) % 26);

		if (root.left == null && root.right == null) {
			// leaf node

			String temp = sb.reverse().toString(); // call this crap only once.

			if (result == null) {
				result = temp;
			} else if (result.compareTo(temp) > 0) {
				result = temp;
			}

			sb.reverse(); // revert it again now for original string
		}

		util(root.left, sb);
		util(root.right, sb);
		sb.deleteCharAt(sb.length() - 1);

	}
}
