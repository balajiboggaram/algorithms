package me.learn.personal.month1;

import me.learn.utli.ListUtils;

public class MergeTwoSortedLists {

	public static void main(String args[]) {
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

		MergeTwoSortedLists solution = new MergeTwoSortedLists();
		ListUtils.printList(solution.mergeTwoLists(l1, m1));

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode resultHead = new ListNode(0);
		ListNode result = resultHead;
		while (l1 != null && l2 != null) {
			System.out.println(l1.val);
			if (l1.val <= l2.val) {
				result.next = l1;
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				result.next = l2;
				l2 = l2.next;
			} 
			result = result.next;
		}
		
		while(l1 != null) {
			result.next = l1;
			result = result.next;
			l1 = l1.next;
		}
		while(l2 != null) {
			result.next = l2;
			result = result.next;
			l2 = l2.next;
		}

		return resultHead.next;

	}

}
