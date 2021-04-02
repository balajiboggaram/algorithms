/**
 * 
 */
package me.learn.personal.month5;

import java.util.Stack;

import me.learn.utli.TreeNode;

/**
 * Title 897 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class IncreasingOrderSearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given a BST, make it right child only tree in an increasing order. none of
	// the nodes should have a left child

	// Basically, an inorder traversal with iterative order
	public TreeNode increasingBST(TreeNode root) {

		TreeNode dummyHead = new TreeNode(0);
		TreeNode dummy = dummyHead;
		if (root == null)
			return null;

		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !st.isEmpty()) {

			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}

			TreeNode temp = new TreeNode(st.peek().val);
			dummy.right = temp;
			dummy = dummy.right;

			cur = st.pop();

			cur = cur.right;

		}

		return dummyHead.right;

	}

	// relinking DFS - solution 2
	TreeNode cur;
	public TreeNode increasingBSTDFS(TreeNode root) {
		TreeNode ans = new TreeNode(0);
		cur = ans;
		inorder(root);
		return ans.right;
	}

	public void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		node.left = null;
		cur.right = node;
		cur = node;
		inorder(node.right);
	}

}
