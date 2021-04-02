/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.learn.utli.TreeNode;

/**
 * Title 652 :
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class FindDuplicateSubTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<String, Integer> count = new HashMap<String, Integer>();
	List<TreeNode> result = new ArrayList<TreeNode>();

	// PRE ORDER
	// Take it as a String, Then compare the string in hashmap
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		findUtil(root);

		return result;

	}

	private String findUtil(TreeNode root) {

		if (root == null)
			return "#"; // This is important
		int val = root.val;
		String left = findUtil(root.left);
		String right = findUtil(root.right);

		String s = root.val + left + right;

		count.put(s, count.getOrDefault(s, 0) + 1);

		if (count.get(s) == 2) {
			result.add(root);
		}

		return s;

	}

}
