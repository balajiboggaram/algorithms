/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 1644 :
 * 
 * Date : Dec 29, 2020
 * 
 * @author bramanarayan
 *
 */
public class LCAInBTMayNotExist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// The catch here is that the elements p and q may not be found in the BT. what
	// will you do ?

	// You just need to keep two more extra variables to track their presence, thats
	// it !!
	boolean pFound = false;
	boolean qFound = false;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		TreeNode result = lca(root, p, q);

		if (pFound && qFound)
			return result;
		return null;
	}

	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);

		if (root.val == p.val) {
			pFound = true;
			return root;
		}

		if (root.val == q.val) {
			qFound = true;
			return root;
		}

		if (left != null && right != null)
			return root;

		// return left != null ? left : right != null ? right : root;
		return left == null ? right : right == null ? left : root;

	}

}
