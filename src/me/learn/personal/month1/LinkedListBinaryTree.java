package me.learn.personal.month1;

import me.learn.utli.TreeNode;

/**
 * 
 * Title 1367 : Given a binary tree root and a linked list with head as the
 * first node.
 * 
 * Return True if all the elements in the linked list starting from the head
 * correspond to some downward path connected in the binary tree otherwise
 * return False.
 * 
 * In this context downward path means a path that starts at some node and goes
 * downwards.
 * 
 * @author bramanarayan
 * @date May 14, 2020
 */
public class LinkedListBinaryTree {

	public static void main(String args[]) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(8);
		TreeNode t6 = new TreeNode(1);
		TreeNode t7 = new TreeNode(3);
		TreeNode t8 = new TreeNode(1);

		t1.right = t2;
		t2.left = t3;
		t3.left = t4;
		t3.right = t5;
		t8.left = t6;
		t5.right = t7;

		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(8);

		l1.next = l2;
		l2.next = l3;

		LinkedListBinaryTree solution = new LinkedListBinaryTree();
		System.out.println(solution.isSubPath(l1, t1));

	}

	/**
	 * This is tricky why I need isSubPath(head, root.left) || isSubPath(head,
	 * root.right); 
	 * 
	 * Check this post :
	 * https://leetcode.com/problems/linked-list-in-binary-tree/discuss/525828/Possible-reason-for-failing-61st-Test-Case-Accepted
	 */
	public boolean isSubPath(ListNode head, TreeNode root) {
		if(root == null) return false;
		if(head == null) return true;
		//check method tells if the head starts from this node ??
		// the other subPath methods tell if the head starts from either left or right respectively ?
		// So there are 3 combinations that can lead to solution.
		return check(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	public boolean check(TreeNode tNode, ListNode lNode) {
		if (lNode == null)
			return true;
		if (tNode == null)
			return false;
		// As soon as I know there is no match from the current node, no use to further proceed. so skip
		if (tNode.val != lNode.val) {
			return false;
		}

		boolean leftResult = check(tNode.left, lNode.next);
		boolean rightResult = check(tNode.right, lNode.next);
		return leftResult || rightResult; // search either left tree or right tree

	}
}
