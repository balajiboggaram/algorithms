package me.learn.personal.month1;

import me.learn.utli.ListUtils;

/**
 * 
 * Title : Given a sorted linked list, delete all duplicates such that each
 * element appear only once.
 * 
 * 
 * @author bramanarayan
 * @date May 7, 2020
 */
public class RemoveDuplicatesList {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		RemoveDuplicatesList solution = new RemoveDuplicatesList();
		ListNode result = solution.deleteDuplicates(l1);
		ListUtils.printList(result);
		
		result = solution.deleteDuplicates(null);
		ListUtils.printList(result);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode prev = head;
		if (prev.next == null)
			return head;
		ListNode cur = prev.next;

		while (cur != null) {
			if (prev.val != cur.val) {
				prev.next = cur;
				prev = prev.next;
			}
			cur = cur.next;
		}
		prev.next = null; // Mark as end of input list
		return head;

	}

}
