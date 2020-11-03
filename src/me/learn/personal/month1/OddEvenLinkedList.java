package me.learn.personal.month1;

import me.learn.utli.ListUtils;

/**
 * 
 * Title : Given a singly linked list, group all odd nodes together followed by
 * the even nodes. Please note here we are talking about the node number and not
 * the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * @author bramanarayan
 * @date May 12, 2020
 */
public class OddEvenLinkedList {

	public static void main(String args[]) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(7);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		OddEvenLinkedList solution = new OddEvenLinkedList();
		ListNode result = solution.oddEvenList(l1);
		ListUtils.printList(result);
	}

	/**
	 * odd and even based on node
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode oddHead = new ListNode(0);
		ListNode evenHead = new ListNode(0);
		oddHead.next = head;
		evenHead.next = head;
		ListNode odd = oddHead, even = evenHead;
		ListNode cur = head;
		int count = 1;
		while (cur != null) {
			if (count % 2 == 0) {
				even.next = cur;
				even = even.next;
			} else {
				odd.next = cur;
				odd = odd.next;
			}
			count++;
			cur = cur.next;
		}
		even.next = null;
		odd.next = evenHead.next;
		return oddHead.next;
	}

	/**
	 * odd and even based on value
	 */
	public ListNode oddEvenListOnValue(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode oddHead = new ListNode(0);
		ListNode evenHead = new ListNode(0);
		oddHead.next = head;
		evenHead.next = head;
		ListNode odd = oddHead, even = evenHead;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val % 2 == 0) {
				even.next = cur;
				even = even.next;
			} else {
				odd.next = cur;
				odd = odd.next;
			}
			cur = cur.next;
		}
		even.next = null;
		odd.next = evenHead.next;
		return oddHead.next;
	}
}
