/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;

/**
 * Title 285 :
 * 
 * Date : Dec 27, 2020
 * 
 * @author bramanarayan
 *
 */
public class InOrderSuccessorInBSTNoParent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 2 cases
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		TreeNode suc = null;

		if (root == null)
			return null;
		if (p.right != null) {
			return minValue(root.right);
		} else {
			TreeNode cur = root;

			while (cur != null) {
				if (cur.val > p.val) {
					suc = cur;
					cur = cur.left;
				} else if (cur.val < p.val) {
					cur = cur.right;
				} else {
					break;
				}
			}
		}

		return suc;
	}

	private TreeNode minValue(TreeNode cur) {
		if (cur == null)
			return null;
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

}
