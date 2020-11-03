package me.learn.personal.month1;

import me.learn.utli.ListUtils;

public class RemoveDuplicatesRepeat {

	public static void main(String args[]) {
		/*
		 * ListNode l1 = new ListNode(1); ListNode l2 = new ListNode(2); ListNode l3 =
		 * new ListNode(3); ListNode l4 = new ListNode(3); ListNode l5 = new
		 * ListNode(4); ListNode l6 = new ListNode(5); ListNode l7 = new ListNode(5);
		 * 
		 * l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next
		 * = l7;
		 */

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);

		l1.next = l2;
		l2.next = l3;

		RemoveDuplicatesRepeat solution = new RemoveDuplicatesRepeat();
		ListNode result = solution.deleteDuplicates(l1);
		ListUtils.printList(result);
	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;
		if (head.next == null)
			return head;

		ListNode prev = head;
		ListNode cur = head.next;

		// The purpose of creating this dummy head is to avoid null checks. 
		// Like lets say you want to return the sub list of the same input. Its good to create this dummyHead
		ListNode dummyHead = new ListNode(0);
		ListNode result = dummyHead;

		while (cur != null) {
			if (prev.val == cur.val) {
				// found same so skip until the next node is not same
				int value = prev.val;
				while (cur != null && cur.val == value) { // skip all the same values
					cur = cur.next;
				}
			} else {
				// Prev and cur are pointing to distinct values, so add prev to answer
				result.next = prev;
				result = result.next;
				result.next = null;
			}
			prev = cur;
			if (prev != null) {
				cur = prev.next;
			}
		}

		// If there any single left over node . 1->2->3->3->4
		if (prev != null) {
			result.next = prev;
			result = result.next;
			result.next = null;
		}
		return dummyHead.next;
	}
}
