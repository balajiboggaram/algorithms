package me.learn.personal.month1;

/**
 * 
 * Title : LinkedList cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * @author bramanarayan
 * @date May 11, 2020
 */
public class LinkedListCycle {

	public static void main(String args[]) {
		LinkedListCycle solution = new LinkedListCycle();
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;

		System.out.println(solution.hasCycle(l1));

		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(2);
		m1.next = m2;

		System.out.println(solution.hasCycle(m1));

	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		if (head.next == null)
			return false;

		ListNode slow = head, fast = head.next;
		boolean cycle = false;
		while (fast != null) {
			if (slow == fast) {
				cycle = true;
				break;
			}
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		return cycle;
	}
}
