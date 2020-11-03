package me.learn.personal.month1;

import me.learn.utli.ListUtils;

public class SortLinkedLIst {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		SortLinkedLIst solution = new SortLinkedLIst();
		ListUtils.printList(solution.sortList(l1));
	}

	/**
	 * The trick here is to :
	 * 
	 * 1. to divide the list. and always hold the end of first list and assign to
	 * null.
	 */
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode slow = head, fast = head, prev = null;

		while (fast != null) {
			// Make sure you always check the next element of fast is not null.
			if (fast.next == null)
				break;
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;

		ListNode a = sortList(head);
		ListNode b = sortList(slow);

		return sortListUtilMerge(a, b);

	}

	private ListNode sortListUtilMerge(ListNode first, ListNode second) {
		if (first == second && first.next == null) {
			return first;
		}

		ListNode resultHead = new ListNode(0), result = resultHead;

		while (first != null && second != null) {
			if (first.val < second.val) {
				result.next = first;
				first = first.next;
			} else {
				result.next = second;
				second = second.next;
			}
			result = result.next;
		}

		// one node can be more either in first or second
		if (first != null) {
			result.next = first;
		}

		if (second != null) {
			result.next = second;
		}
		return resultHead.next;
	}

	/**
	 * Uses Quick sort - Fix it
	 */
	private ListNode sortListUtilQuick(ListNode head, ListNode tail) {
		System.out.println(head.val + "-->" + tail.val);

		if (head == tail && head.next == null)
			return head;
		ListNode pivot = head;
		ListNode lessHead = new ListNode(0), less = lessHead;
		ListNode moreHead = new ListNode(0), more = moreHead;
		ListNode cur = head.next;
		while (cur != null) {
			if (pivot.val >= cur.val) {
				// its lesser
				less.next = cur;
				less = less.next;
			} else {
				more.next = cur;
				more = more.next;
			}
			cur = cur.next;
		}
		less.next = null;
		more.next = null;
		ListUtils.printList(lessHead);
		ListUtils.printList(moreHead);

		ListNode lessResult = sortListUtilQuick(lessHead.next, less);
		ListNode moreResult = sortListUtilQuick(moreHead.next, more);
		lessResult.next = pivot;
		pivot.next = moreResult;
		return lessResult;
	}
}
