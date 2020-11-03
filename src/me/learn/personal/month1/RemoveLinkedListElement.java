package me.learn.personal.month1;

import me.learn.utli.ListUtils;

/**
 * 
 * Title : Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * @author bramanarayan
 * @date May 7, 2020
 */
public class RemoveLinkedListElement {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		RemoveLinkedListElement solution = new RemoveLinkedListElement();
		ListNode result = solution.removeElements(l1, 6);
		ListUtils.printList(result);
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		
		ListNode dummyHead = new ListNode(0);
		ListNode dummy = dummyHead;
		dummyHead.next = head;
		ListNode cur = head;
		while(cur != null) {
			if(cur.val != val) {
				dummy.next = cur;
				dummy = dummy.next;
			}
			cur = cur.next;
		}
		dummy.next = null;
		return dummyHead.next;
	}
}
