package me.learn.utli;

import me.learn.personal.month1.ListNode;

public class ListExample {

	public void exampleList() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(2);
		ListNode m3 = new ListNode(3);
		ListNode m4 = new ListNode(4);
		ListNode m5 = new ListNode(5);

		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;


		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		
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
		
	}
}
