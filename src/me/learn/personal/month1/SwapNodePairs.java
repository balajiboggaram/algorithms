package me.learn.personal.month1;

import me.learn.utli.ListUtils;

/**
 * 
 * Title :
 * 
 * @author bramanarayan
 * @date May 4, 2020
 */
public class SwapNodePairs {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		// l3.next = l4;

		SwapNodePairs solution = new SwapNodePairs();
		ListNode result = solution.swapPairs(l1);
		ListUtils.printList(result);

	}

	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode prev = head;
		ListNode cur = head.next;
		ListNode result = cur;

		while (true) {
			ListNode future = cur.next;
			cur.next = prev;
			if (future == null || future.next == null) {
				prev.next = future;
				break; // end of the list
			}
			prev.next = future.next;
			prev = future;
			cur = prev.next;
		}

		return result;
	}
}
