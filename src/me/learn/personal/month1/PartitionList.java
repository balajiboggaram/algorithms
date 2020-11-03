package me.learn.personal.month1;

import me.learn.utli.ListUtils;

/**
 * 
 * Title : Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * @author bramanarayan
 * @date May 14, 2020
 */
public class PartitionList {

	public static void main(String args[]) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		PartitionList solution = new PartitionList();
		ListNode result = solution.partition(l1, 3);
		ListUtils.printList(result);
		
	}

	public ListNode partition(ListNode head, int x) {

		if (head == null || head.next == null)
			return head;

		ListNode cur = head;
		ListNode greaterHead = new ListNode(0);
		ListNode lessHead = new ListNode(0);
		ListNode great = greaterHead, less = lessHead;
		greaterHead.next = head;
		lessHead.next = head;

		while (cur != null) {
			if (cur.val < x) {
				less.next = cur;
				less = less.next;
			} else {
				great.next = cur;
				great = great.next;
			}
			cur = cur.next;
		}
		great.next = null;

		less.next = greaterHead.next;
		return lessHead.next;

	}
}
