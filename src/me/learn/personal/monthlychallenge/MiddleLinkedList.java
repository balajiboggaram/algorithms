package me.learn.personal.monthlychallenge;

import me.learn.personal.month1.ListNode;

/**
 * 
 * Title : Find the middle of given linked list
 * 
 * @author bramanarayan
 * @date May 1, 2020
 */
public class MiddleLinkedList {

	public static void main(String args[]) {
		/*
		 * ListNode l1 = new ListNode(1); ListNode l2 = new ListNode(2); ListNode l3 =
		 * new ListNode(3); ListNode l4 = new ListNode(4); ListNode l5 = new
		 * ListNode(5);
		 * 
		 * l1.next = l2; // 1-> 2 -> 3 -> 4 -> 5 l2.next = l3; l3.next = l4; l4.next =
		 * l5;
		 */

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2; // 1-> 2 -> 3 -> 4
		l2.next = l3;
		l3.next = l4;
		MiddleLinkedList solution = new MiddleLinkedList();
		solution.middleNode(l1);

	}

	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slow = head, fast = head;

		while (fast != null) {
			// Make sure you always check the next element of fast is not null.
			if (fast.next == null)
				break;
			fast = fast.next.next;
			slow = slow.next;

		}
		System.out.println(slow.val);
		return slow;
	}

}
