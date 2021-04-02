/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import me.learn.utli.TreeNode;

/**
 * Title 1676 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class LCAForSetOfNodesInBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	Set<Integer> set = new HashSet<Integer>();

	TreeNode lca;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

		// add the nodes to set
		for (TreeNode node : nodes) {
			set.add(node.val);
		}

		getKeysCount(root, set);
		return lca;
	}

	private int getKeysCount(TreeNode root, Set<Integer> set) {

		if (root == null)
			return 0;

		int left = getKeysCount(root.left, set);
		int right = getKeysCount(root.right, set);

		int count = left + right;
		if (set.contains(root.val)) {
			count++; // because a node can itself be an LCA to itself
		}

		if (lca == null && count == set.size()) {
			lca = root;
		}

		return count;

	}
}
