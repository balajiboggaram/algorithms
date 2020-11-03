package me.learn.personal.month1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * Title 87 : We are given head, the head node of a linked list containing
 * unique integer values.
 * 
 * We are also given the list G, a subset of the values in the linked list.
 * 
 * Return the number of connected components in G, where two values are
 * connected if they appear consecutively in the linked list.
 * 
 * @author bramanarayan
 * @date May 14, 2020
 */
public class LinkedListComponents {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ListNode m1 = new ListNode(0);
		ListNode m2 = new ListNode(1);
		ListNode m3 = new ListNode(2);
	
		m1.next = m2;
		m2.next = m3;
		
		LinkedListComponents solution = new LinkedListComponents();
		System.out.println(solution.numComponents(l1, new int[] { 0, 3, 1, 4 }));
		System.out.println(solution.numComponents(m1, new int[] { 0, 2 }));

	}

	/**
	 * Each connected component in a list is a graph. check example with m1 node
	 */	
	public int numComponents(ListNode head, int[] G) {
		if (head == null || G.length == 0)
			return 0;
		ListNode cur = head;
		Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toSet());
		int result = 0, count = 0;
		while (cur != null) {
			if (set.contains(cur.val)) {
				if(count == 0) {
					result++;
				}
				count++;
			} else {
				count = 0;
			}
			cur = cur.next;
		}
		return result;
	}
}
