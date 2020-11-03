package me.learn.personal.month1;

/**
 * 
 * Title 160 : Write a program to find the node at which the intersection of two
 * singly linked lists begins.
 * 
 * @author bramanarayan
 * @date May 15, 2020
 */
public class IntersectionLists {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(8);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(0);
		ListNode m3 = new ListNode(1);

		m1.next = m2;
		m2.next = m3;
		m3.next = l3;
		
		IntersectionLists solution = new IntersectionLists();
		ListNode result = solution.getIntersectionNode(l1, m1);
		System.out.println(result.val);
		
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		int l1 = lengthList(headA);
		int l2 = lengthList(headB);
		if (l1 > l2) {
			headA = traverseList(headA, l1 - l2);
		} else {
			headB = traverseList(headB, l2 - l1);
		}
		
		while (headA != null && headB != null && headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;

	}

	private ListNode traverseList(ListNode headA, int count) {
		while (count > 0) {
			headA = headA.next;
			count--;
		}
		return headA;
	}

	int lengthList(ListNode l) {
		ListNode cur = l;
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
}
